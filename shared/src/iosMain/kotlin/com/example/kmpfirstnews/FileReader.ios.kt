package com.example.kmpfirstnews

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithContentsOfFile

actual class FileReader actual constructor() {
    @OptIn(ExperimentalForeignApi::class)
    actual fun readFile(path: String): String {
        return NSString.stringWithContentsOfFile(
            path,
            encoding = NSUTF8StringEncoding,
            error = null
        ) as String
    }
}