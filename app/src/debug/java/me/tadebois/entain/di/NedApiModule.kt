package me.tadebois.entain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.tadebois.entain.nedapi.NedApi
import me.tadebois.entain.nedapi.NedApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Debug
@Module
@InstallIn(SingletonComponent::class)
object NedApiModule {

    @Provides
    @Singleton
    fun provideNedApi(apiService: NedApiService): NedApi {
        return NedApi(apiService)
    }

    @Provides
    @Singleton
    fun provideNedApiService(): NedApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.neds.com.au/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NedApiService::class.java)
    }
}

