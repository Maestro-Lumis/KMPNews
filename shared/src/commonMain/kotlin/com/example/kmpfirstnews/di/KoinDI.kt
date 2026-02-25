package com.example.kmpfirstnews.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            serviceModule,
            useCaseModule,
            viewModelModule
        )
    }
}