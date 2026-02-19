package com.example.kmpfirstnews.Notification

interface PushNotificationManager {
    suspend fun registerForPushNotifications(): PushNotificationResult
    suspend fun unregisterFromPushNotifications()
    suspend fun getToken(): PushNotificationResult
    fun setNotificationHandler(handler: (NotificationPayload) -> Unit)
}