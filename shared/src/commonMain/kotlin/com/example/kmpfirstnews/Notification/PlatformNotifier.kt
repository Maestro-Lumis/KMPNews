package com.example.kmpfirstnews.Notification

interface PlatformNotifier {
    suspend fun register(): String
    fun unregister()
    fun getToken(): String
}