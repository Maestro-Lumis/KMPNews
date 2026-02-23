package com.example.kmpfirstnews

expect class FileReader constructor() {
    fun readFile(path: String): String
}