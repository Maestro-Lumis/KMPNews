package com.example.kmpfirstnews

import com.example.kmpfirstnews.util.uiDispatcher

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

open class BaseViewModel(dispatcher: kotlinx.coroutines.CoroutineDispatcher = uiDispatcher) {
    private val job = SupervisorJob()
    val scope = CoroutineScope(dispatcher + job)

    fun onDestroy() {
        scope.cancel()
    }
}