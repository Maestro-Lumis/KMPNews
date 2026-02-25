package com.example.kmpfirstnews.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

expect fun createHttpClient(): HttpClient

class NetworkClient {
    private val httpClient: HttpClient = createHttpClient()

    suspend fun loadData(path: String): String {
        return httpClient.get(path).body()
    }
}