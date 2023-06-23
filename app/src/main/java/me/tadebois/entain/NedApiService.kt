package me.tadebois.entain

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NedApiService {
    @GET("rest/v1/racing")
    fun getNextRaces(
        @Query("method") method: String = "nextraces",
        @Query("count") count: Int = 2
    ): Call<ApiResponse>
}