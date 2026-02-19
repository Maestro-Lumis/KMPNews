package com.example.kmpfirstnews

import com.example.kmpfirstnews.Notification.PlatformNotifier

class PlatformNotifierAndroid : PlatformNotifier {
    override suspend fun register(): String {
        return "" // TODO: Firebase в будущем
    }
    override fun unregister() {}
    override fun getToken(): String = ""
}