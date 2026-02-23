package com.example.kmpfirstnews

import java.io.File

actual class FileReader actual constructor() {
    actual fun readFile(path: String): String {
        return File(path).readText()
    }
}