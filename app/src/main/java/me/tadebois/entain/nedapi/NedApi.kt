package me.tadebois.entain.nedapi

class NedApi(private val apiService: NedApiService) {

    suspend fun getNextRaces(): ApiResponse {
        return apiService.getNextRaces()
    }
}
