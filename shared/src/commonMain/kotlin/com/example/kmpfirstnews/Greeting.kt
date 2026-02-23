package com.example.kmpfirstnews

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello from ${platform.name}! Today: ${getCurrentDate()}"
    }
}