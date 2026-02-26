package com.example.kmpfirstnews.di

import com.example.kmpfirstnews.NewsUseCase
import com.example.kmpfirstnews.NewsViewModel
import com.example.kmpfirstnews.network.NetworkClient
import com.example.kmpfirstnews.service.NewsService
import com.example.kmpfirstnews.storage.NewsDataStore
import com.example.kmpfirstnews.storage.Storage
import com.example.kmpfirstnews.storage.createDataStore
import org.koin.dsl.module

val serviceModule = module {
    single { NetworkClient() }
    single { Storage() }
    single { NewsService(get(), get()) }
}

val useCaseModule = module {
    factory { NewsUseCase() }
}

val viewModelModule = module {
    factory { NewsViewModel() }
}

val storageModule = module {
    single { NewsDataStore(createDataStore()) }
}