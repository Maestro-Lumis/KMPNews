package com.example.kmpfirstnews

import com.example.kmpfirstnews.data.NewsItem
import com.example.kmpfirstnews.network.NetworkClient
import com.example.kmpfirstnews.network.NetworkConfiguration
import com.example.kmpfirstnews.service.NewsService
import com.example.kmpfirstnews.storage.Storage
import com.example.kmpfirstnews.util.ioDispatcher
import com.example.kmpfirstnews.util.uiDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel : BaseViewModel() {
    private val service = NewsService(
        NetworkClient(),
        Storage()
    )

    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news: StateFlow<List<NewsItem>> = _news

    fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                service.loadNews()
            }
            result.onSuccess { data ->
                _news.value = data.articles
            }
        }
    }
    fun observeNews(onChange: (List<NewsItem>) -> Unit) {
        scope.launch {
            news.collect { items ->
                onChange(items)
            }
        }
    }
}