package com.example.kmpfirstnews

import androidx.lifecycle.viewModelScope
import com.example.kmpfirstnews.data.NewsItem
import com.example.kmpfirstnews.storage.NewsDataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsViewModel : BaseViewModel(), KoinComponent {
    private val useCase = NewsUseCase()
    private val dataStore: NewsDataStore by inject()

    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news: StateFlow<List<NewsItem>> = _news

    private val _selectedNews = MutableStateFlow<NewsItem?>(null)
    val selectedNews: StateFlow<NewsItem?> = _selectedNews

    private val _state = MutableStateFlow<NewsState>(NewsState.Idle)
    val state: StateFlow<NewsState> = _state

    private val _favorites = MutableStateFlow<Set<String>>(emptySet())
    val favorites: StateFlow<Set<String>> = _favorites

    init {
        scope.launch {
            dataStore.favorites.collect { ids ->
                _favorites.value = ids
            }
        }
    }

    fun selectNews(item: NewsItem) {
        _selectedNews.value = item
    }

    fun toggleFavorite(item: NewsItem) {
        scope.launch {
            val id = item.url ?: return@launch
            if (_favorites.value.contains(id)) {
                dataStore.removeFavorite(id)
            } else {
                dataStore.addFavorite(id)
            }
        }
    }

    fun loadNews() {
        viewModelScope.launch {
            _state.value = NewsState.Loading
            val result = useCase(Unit)
            result.onSuccess { data ->
                _news.value = data?.articles ?: emptyList()
                _state.value = NewsState.Success
            }
            result.onFailure { error ->
                _state.value = NewsState.Error(error.message ?: "Unknown error")
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