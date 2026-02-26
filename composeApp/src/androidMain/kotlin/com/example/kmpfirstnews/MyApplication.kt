package com.example.kmpfirstnews

import android.app.Application
import com.example.kmpfirstnews.Notification.NotificationManagerImpl
import com.example.kmpfirstnews.di.initKoin
import com.example.kmpfirstnews.storage.appContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // FirebaseApp.initializeApp(this) — добавим когда подключим Firebase

        appContext = this
        initKoin()

        val notificationManager = NotificationManagerImpl(
            PlatformNotifierAndroid()
        )
        notificationManager.setNotificationHandler { payload ->
            // Обработка уведомлений
        }
    }
}