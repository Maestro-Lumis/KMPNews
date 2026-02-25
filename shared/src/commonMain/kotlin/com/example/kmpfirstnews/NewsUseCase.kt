package com.example.kmpfirstnews

import com.example.kmpfirstnews.data.NewsItemsList
import com.example.kmpfirstnews.network.NetworkClient
import com.example.kmpfirstnews.service.NewsService
import com.example.kmpfirstnews.storage.Storage

class NewsUseCase : BaseUseCase<Unit, NewsItemsList?>() {
    private val newsService = NewsService(NetworkClient(), Storage())

    override suspend fun execute(param: Unit): NewsItemsList? {
        return newsService.loadNews().getOrNull()
    }
}