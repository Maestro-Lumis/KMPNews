package com.example.kmpfirstnews.service

import com.example.kmpfirstnews.data.NewsItemsList
import com.example.kmpfirstnews.network.NetworkClient
import com.example.kmpfirstnews.network.NetworkConfiguration
import com.example.kmpfirstnews.storage.Storage
import kotlinx.serialization.json.Json

class NewsService(
    private val networkClient: NetworkClient,
    private val storage: Storage
) {
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun loadNews(): Result<NewsItemsList> {
        return try {
            val text = networkClient.loadData(
                "${NetworkConfiguration.BASE_URL}everything?q=science&apiKey=${NetworkConfiguration.API_KEY}"
            )
            val result = json.decodeFromString<NewsItemsList>(text)
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}