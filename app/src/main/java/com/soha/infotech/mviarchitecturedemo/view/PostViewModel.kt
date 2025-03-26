package com.soha.infotech.mviarchitecturedemo.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soha.infotech.mviarchitecturedemo.data.repository.PostRepository
import com.soha.infotech.mviarchitecturedemo.intent.PostIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

// Step 8: Create ViewModel

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {
    private val _state = MutableStateFlow<PostState>(PostState.Loading)
    val state: StateFlow<PostState> = _state.asStateFlow()

    // MVI Specific code
    private val _intent = MutableSharedFlow<PostIntent>(replay = 0)
    val intent: SharedFlow<PostIntent> = _intent.asSharedFlow()

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intent.collect { postIntent ->
                when (postIntent) {
                    is PostIntent.LoadPosts -> fetchPosts()
                }
            }
        }
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            repository.getPosts()
                .onStart { _state.value = PostState.Loading }
                .catch { e -> _state.value = PostState.Error(e.message ?: "Unknown Error") }
                .collect { posts -> _state.value = PostState.Success(posts) }

        }
    }

    // MVI Specific code
    fun sendIntent(postIntent: PostIntent) {
        viewModelScope.launch {
            _intent.emit(postIntent)
        }
    }
}
