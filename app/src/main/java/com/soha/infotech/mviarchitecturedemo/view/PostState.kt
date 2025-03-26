package com.soha.infotech.mviarchitecturedemo.view

import com.soha.infotech.mviarchitecturedemo.model.Post

// Step 7: Define State

sealed class PostState {
    object Loading : PostState()
    data class Success(val posts: List<Post>) : PostState()
    data class Error(val message: String) : PostState()
}