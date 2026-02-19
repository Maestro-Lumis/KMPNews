package com.example.kmpfirstnews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform