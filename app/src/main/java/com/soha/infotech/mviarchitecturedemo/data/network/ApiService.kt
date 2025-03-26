package com.soha.infotech.mviarchitecturedemo.data.network

import com.soha.infotech.mviarchitecturedemo.model.Post
import retrofit2.http.GET

// Step 3: Create API Service

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}