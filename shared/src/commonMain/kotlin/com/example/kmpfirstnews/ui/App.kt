package com.example.kmpfirstnews.ui

import androidx.compose.runtime.*
import com.example.kmpfirstnews.NewsViewModel
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun App(viewModel: NewsViewModel) {
    PreComposeApp {
        val navigator = rememberNavigator()

        LaunchedEffect(Unit) {
            viewModel.loadNews()
        }

        NavHost(
            navigator = navigator,
            initialRoute = NewsScreen.NewsList.name
        ) {
            scene(route = NewsScreen.NewsList.name) {
                NewsListScreen(viewModel) { item ->
                    navigator.navigate(NewsScreen.NewsItem.name)
                }
            }
            scene(route = NewsScreen.NewsItem.name) {
                NewsItemScreen(
                    item = viewModel.news.value.firstOrNull() ?: return@scene
                )
            }
        }
    }
}