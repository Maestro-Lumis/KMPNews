package com.example.kmpfirstnews.service

import com.example.kmpfirstnews.data.NewsItem
import com.example.kmpfirstnews.network.NetworkClient
import com.example.kmpfirstnews.storage.Storage

class NewsService(
    private val networkClient: NetworkClient,
    private val storage: Storage
) {
    fun loadData() {
        // TODO: реализация
    }
}