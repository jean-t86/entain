package me.tadebois.entain.nedapi

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import me.tadebois.entain.nedapi.ApiResponseTestData.GET_NEXT_TWO_RACES_RESPONSE
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NedApiServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var nedApi: NedApi

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val gson: Gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val apiService = retrofit.create(NedApiService::class.java)
        nedApi = NedApi(apiService)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testGetNextRaces() = runBlocking {
        mockWebServer.enqueue(MockResponse().setBody(GET_NEXT_TWO_RACES_RESPONSE))

        val response = nedApi.getNextRaces()

        assertEquals(200, response.status)
        assertNotNull(response.data)
        assertEquals(2, response.data.nextToGoIds.count())
        assertEquals("Success", response.message)

        val recordedRequest = mockWebServer.takeRequest()
        assertEquals("/rest/v1/racing/?method=nextraces&count=2", recordedRequest.path)
        assertEquals("GET", recordedRequest.method)
    }
}
