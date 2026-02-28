package com.example.kmpfirstnews

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmpfirstnews.ui.App
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object IOSViewModelProvider : KoinComponent {
    val viewModel: NewsViewModel by inject()
}

@Suppress("unused")
fun MainViewController() = ComposeUIViewController {
    App(IOSViewModelProvider.viewModel)
}