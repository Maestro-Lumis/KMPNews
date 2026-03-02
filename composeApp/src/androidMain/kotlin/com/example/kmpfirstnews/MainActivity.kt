package com.example.kmpfirstnews

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kmpfirstnews.ui.App
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: NewsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkUrl = intent?.data?.getQueryParameter("url")
        setContent {
            App(viewModel, deepLinkUrl)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        // Обработка deep link когда приложение уже открыто
        val url = intent.data?.getQueryParameter("url")
        if (url != null) {
            viewModel.selectNewsByUrl(url)
        }
    }
}