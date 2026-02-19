package com.example.kmpfirstnews

import com.example.kmpfirstnews.network.NetworkClient
import com.example.kmpfirstnews.network.NetworkConfiguration
import com.example.kmpfirstnews.service.NewsService
import com.example.kmpfirstnews.storage.Storage

class NewsViewModel : BaseViewModel() {
    private val service = NewsService(
        NetworkClient(NetworkConfiguration()),
        Storage()
    )
}