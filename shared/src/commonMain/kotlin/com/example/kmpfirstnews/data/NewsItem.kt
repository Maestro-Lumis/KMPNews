package com.example.kmpfirstnews.data

data class NewsItem(
    val source: Source? = null,
    val author: String,
    val title: String,
    val description: String,
    val url: String? = null,
    val publishedAt: String? = null,
    val content: String,
    val urlToImage: String? = null
)