package com.soha.infotech.mviarchitecturedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.soha.infotech.mviarchitecturedemo.ui.theme.MVIArchitectureDemoTheme
import com.soha.infotech.mviarchitecturedemo.view.PostScreen
import com.soha.infotech.mviarchitecturedemo.view.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

// Step 10: Setup Main Activity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // Create ViewModel instance using Hilt
    val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVIDemoApp(viewModel)
        }
    }
}

@Composable
fun MVIDemoApp(viewModel: PostViewModel) {
    PostScreen(viewModel = viewModel) // Pass ViewModel to PostScreen
}