package com.example.kmpfirstnews.data

import kotlinx.serialization.Serializable

@Serializable
data class NewsItem(
    val source: Source? = null,
    val author: String? = null,
    val title: String = "",
    val description: String? = null,
    val url: String? = null,
    val publishedAt: String? = null,
    val content: String? = null,
    val urlToImage: String? = null
)