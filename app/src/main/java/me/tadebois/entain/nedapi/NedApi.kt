package me.tadebois.entain.nedapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NedApi {
    private val apiService: NedApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.neds.com.au/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(NedApiService::class.java)
    }

    suspend fun getNextRaces(): ApiResponse {
        return apiService.getNextRaces()
    }
}
