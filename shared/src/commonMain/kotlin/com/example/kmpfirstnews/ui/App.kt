package com.example.kmpfirstnews.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.kmpfirstnews.NewsViewModel
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun App(
    viewModel: NewsViewModel,
    deepLinkUrl: String? = null
) {
    PreComposeApp {
        val navigator = rememberNavigator()
        var selectedTab by remember { mutableStateOf(0) }

        LaunchedEffect(Unit) {
            viewModel.loadNews()
        }

        // Обработка deep link
        LaunchedEffect(deepLinkUrl) {
            if (deepLinkUrl != null) {
                viewModel.selectNewsByUrl(deepLinkUrl)
                navigator.navigate(NewsScreen.NewsItem.name)
            }
        }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = selectedTab == 0,
                        onClick = {
                            selectedTab = 0
                            navigator.navigate(NewsScreen.NewsList.name)
                        },
                        icon = { Icon(Icons.Filled.Home, contentDescription = "News") },
                        label = { Text("News") }
                    )
                    NavigationBarItem(
                        selected = selectedTab == 1,
                        onClick = {
                            selectedTab = 1
                            navigator.navigate(NewsScreen.Favorites.name)
                        },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
                        label = { Text("Favorites") }
                    )
                }
            }
        ) { padding ->
            NavHost(
                navigator = navigator,
                initialRoute = NewsScreen.NewsList.name,
                modifier = Modifier.padding(padding)
            ) {
                scene(route = NewsScreen.NewsList.name) {
                    NewsListScreen(viewModel) { item ->
                        viewModel.selectNews(item)
                        navigator.navigate(NewsScreen.NewsItem.name)
                    }
                }
                scene(route = NewsScreen.Favorites.name) {
                    FavoritesScreen(viewModel) { item ->
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
}