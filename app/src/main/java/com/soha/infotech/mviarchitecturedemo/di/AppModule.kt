package com.soha.infotech.mviarchitecturedemo.di

import com.soha.infotech.mviarchitecturedemo.data.network.ApiService
import com.soha.infotech.mviarchitecturedemo.data.repository.PostRepository
import com.soha.infotech.mviarchitecturedemo.util.Utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Step 4: Setup Hilt

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    // Step 5.1: Provide Repository
    @Provides
    fun providePostRepository(apiService: ApiService): PostRepository {
        return PostRepository(apiService)
    }


}