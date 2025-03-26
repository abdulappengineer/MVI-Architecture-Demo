package com.soha.infotech.mviarchitecturedemo.intent

// Step 6: Define MVI Intent

sealed class PostIntent {
    object LoadPosts : PostIntent()
}