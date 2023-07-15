package me.tadebois.entain.nedapi

import retrofit2.http.GET
import retrofit2.http.Query

interface NedApiService {
    @GET("rest/v1/racing/")
    suspend fun getNextRaces(
        @Query("method") method: String = "nextraces",
        @Query("count") count: Int = MAX_RACES
    ): ApiResponse
}

const val MAX_RACES = 60
