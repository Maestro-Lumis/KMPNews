package com.example.kmpfirstnews.di

import org.koin.core.context.startKoin

object KoinHelper {
    fun initKoin() {
        startKoin {
            modules(
                serviceModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}