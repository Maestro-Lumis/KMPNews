package com.example.kmpfirstnews

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

actual fun getCurrentDate(): String {
    val formatter = NSDateFormatter()
    formatter.dateFormat = "dd.MM.yyyy"
    return formatter.stringFromDate(NSDate())
}