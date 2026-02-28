package com.example.kmpfirstnews

import com.example.kmpfirstnews.data.NewsItemsList
import com.example.kmpfirstnews.service.NewsService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NewsUseCase : BaseUseCase<Unit, NewsItemsList?>(), KoinComponent {
    private val newsService: NewsService by inject()

    override suspend fun execute(param: Unit): NewsItemsList? {
        val result = newsService.loadNews()
        result.onFailure { println("NewsUseCase: error = ${it.message}") }
        return result.getOrNull()
    }
}