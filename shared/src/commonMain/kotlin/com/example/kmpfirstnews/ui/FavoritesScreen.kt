package com.example.kmpfirstnews.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmpfirstnews.NewsViewModel

@Composable
fun FavoritesScreen(
    viewModel: NewsViewModel,
    onClick: (com.example.kmpfirstnews.data.NewsItem) -> Unit
) {
    val news by viewModel.news.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    val favoriteNews = news.filter { favorites.contains(it.url) }

    if (favoriteNews.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "No favorites yet",
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(favoriteNews) { item ->
                NewsListItemView(
                    item = item,
                    isFavorite = true,
                    onFavoriteClick = { viewModel.toggleFavorite(item) },
                    modifier = Modifier.clickable { onClick(item) }
                )
            }
        }
    }
}