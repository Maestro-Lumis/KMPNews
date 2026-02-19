package com.example.kmpfirstnews.Notification

data class NotificationPayload(
    val title: String,
    val body: String,
    val data: Map<String, String>
)

sealed class PushNotificationResult {
    data class Success(val token: String) : PushNotificationResult()
    data class Failure(val error: Throwable) : PushNotificationResult()
}