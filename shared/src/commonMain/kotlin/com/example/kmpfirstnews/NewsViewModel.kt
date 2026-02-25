package com.example.kmpfirstnews

import androidx.lifecycle.viewModelScope
import com.example.kmpfirstnews.data.NewsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : BaseViewModel() {
    private val useCase = NewsUseCase()

    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news: StateFlow<List<NewsItem>> = _news

    fun loadNews() {
        viewModelScope.launch {
            val result = useCase(Unit)
            result.getOrNull()?.let { data ->
                _news.value = data.articles
            }
        }
    }

    fun observeNews(onChange: (List<NewsItem>) -> Unit) {
        viewModelScope.launch {
            news.collect { items ->
                onChange(items)
            }
        }
    }
}