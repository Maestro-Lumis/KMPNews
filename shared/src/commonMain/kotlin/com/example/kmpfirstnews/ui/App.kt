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
                    viewModel.selectNews(item)
                    navigator.navigate(NewsScreen.NewsItem.name)
                }
            }
            scene(route = NewsScreen.NewsItem.name) {
                val item by viewModel.selectedNews.collectAsState()
                item?.let {
                    NewsItemScreen(
                        item = it,
                        onBack = { navigator.goBack() }
                    )
                }
            }
        }
    }
}