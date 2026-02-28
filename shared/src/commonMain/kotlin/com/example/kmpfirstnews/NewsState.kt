package com.example.kmpfirstnews

sealed class NewsState {
    object Idle : NewsState()
    object Loading : NewsState()
    object Success : NewsState()
    data class Error(val message: String) : NewsState()
}