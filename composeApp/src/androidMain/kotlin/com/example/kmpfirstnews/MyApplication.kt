package com.example.kmpfirstnews

import android.app.Application
import com.example.kmpfirstnews.Notification.NotificationManagerImpl

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // FirebaseApp.initializeApp(this) — добавим когда подключим Firebase

        val notificationManager = NotificationManagerImpl(
            PlatformNotifierAndroid()
        )
        notificationManager.setNotificationHandler { payload ->
            // Обработка уведомлений
        }
    }
}