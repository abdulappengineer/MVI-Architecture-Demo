package com.soha.infotech.mviarchitecturedemo.data.repository

import android.util.Log
import com.soha.infotech.mviarchitecturedemo.data.network.ApiService
import com.soha.infotech.mviarchitecturedemo.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

// Step 5: Create Repository

@Singleton
class PostRepository @Inject constructor(val apiService: ApiService) {
    fun getPosts(): Flow<List<Post>> = flow {
        emit(apiService.getPosts())
    }.catch { e ->
        Log.e("PostRepository", "Error: ${e.message}")
    }.flowOn(Dispatchers.IO)
}