package com.example.kmpfirstnews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmpfirstnews.data.NewsItem

@ExperimentalMaterial3Api
@Composable
fun NewsListScreen(viewModel: NewsViewModel = NewsViewModel()) {

    val news = remember { mutableStateListOf<NewsItem>() }

    LaunchedEffect(Unit) {
        // Здесь будет загрузка данных
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("News") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(news) { item ->
                NewsItemRow(item = item)
            }
        }
    }
}

@Composable
fun NewsItemRow(item: NewsItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.publishedAt ?: "",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}