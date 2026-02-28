package com.example.kmpfirstnews.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmpfirstnews.NewsViewModel
import com.example.kmpfirstnews.data.NewsItem

@Composable
fun NewsListScreen(
    viewModel: NewsViewModel,
    onClick: (NewsItem) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.loadNews()
    }

    val news by viewModel.news.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(news) { item ->
            NewsListItemView(
                item = item,
                modifier = Modifier.clickable { onClick(item) }
            )
        }
    }
}

@Composable
fun NewsListItemView(
    item: NewsItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.description ?: "",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.publishedAt ?: "",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}