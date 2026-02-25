package com.example.kmpfirstnews.data

import kotlinx.serialization.Serializable

@Serializable
data class NewsItemsList(
    val totalResults: Int = 0,
    val articles: List<NewsItem> = emptyList()
)