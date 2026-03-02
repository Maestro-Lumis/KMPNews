package com.example.kmpfirstnews.ui

enum class NewsScreen {
    NewsList,
    NewsItem,
    Favorites;

    companion object {
        const val DEEP_LINK_ROUTE = "newsitem/{url}"
    }
}