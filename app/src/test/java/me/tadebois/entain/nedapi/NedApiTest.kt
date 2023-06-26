package me.tadebois.entain.nedapi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NedApiTest {

    @Mock
    private lateinit var apiService: NedApiService

    private lateinit var nedApi: NedApi

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        nedApi = NedApi(apiService)
    }

    @Test
    fun testGetNextRaces_success() = runBlocking {
        val responseType = object : TypeToken<ApiResponse>() {}.type
        val mockedResponse: ApiResponse = Gson().fromJson(
            ApiResponseTestData.GET_NEXT_TWO_RACES_RESPONSE,
            responseType
        )
        `when`(apiService.getNextRaces()).thenReturn(mockedResponse)

        val result = nedApi.getNextRaces()

        verify(apiService).getNextRaces()
        assertEquals(mockedResponse, result)
    }

    @Test
    fun testGetNextRaces_error() = runBlocking {
        // Mocked exception
        val mockedException = RuntimeException("API error")
        `when`(apiService.getNextRaces()).thenThrow(mockedException)

        var exceptionThrown = false
        try {
            nedApi.getNextRaces()
        } catch (e: Exception) {
            exceptionThrown = true
        }

        verify(apiService).getNextRaces()
        assertTrue(exceptionThrown)
    }
}
