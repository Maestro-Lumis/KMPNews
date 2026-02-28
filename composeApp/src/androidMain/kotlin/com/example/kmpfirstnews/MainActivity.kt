package com.example.kmpfirstnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kmpfirstnews.ui.App
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: NewsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(viewModel)
        }
    }
}