package com.example.kmpfirstnews

import com.example.kmpfirstnews.data.NewsItemsList
import com.example.kmpfirstnews.service.NewsService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsUseCase : BaseUseCase<Unit, NewsItemsList?>(), KoinComponent {
    private val newsService: NewsService by inject()

    override suspend fun execute(param: Unit): NewsItemsList? {
        return newsService.loadNews().getOrNull()
    }
}