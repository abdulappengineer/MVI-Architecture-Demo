package com.soha.infotech.mviarchitecturedemo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.soha.infotech.mviarchitecturedemo.intent.PostIntent

// Step 8: Create UI Screen

@Composable
fun PostScreen(viewModel: PostViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sendIntent(PostIntent.LoadPosts)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        when (val currentState = state.value) {
            is PostState.Loading -> CircularProgressIndicator() // Centered
            is PostState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(currentState.posts) { post ->
                        Text(text = post.title, modifier = Modifier.padding(8.dp))
                    }
                }
            }

            is PostState.Error -> Text(
                text = "Error: ${currentState.message}",
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}