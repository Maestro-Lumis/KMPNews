package com.example.kmpfirstnews

import platform.Foundation.*

actual fun getCurrentDate(): String {
    val formatter = NSDateFormatter()
    formatter.dateFormat = "dd.MM.yyyy"
    return formatter.stringFromDate(NSDate())
}

actual fun formatNewsDate(isoDate: String): String {
    return try {
        val inputFormatter = NSDateFormatter()
        inputFormatter.dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
        inputFormatter.locale = NSLocale(localeIdentifier = "en_US_POSIX")
        val date = inputFormatter.dateFromString(isoDate) ?: return isoDate
        val outputFormatter = NSDateFormatter()
        outputFormatter.dateFormat = "d MMM yyyy"
        outputFormatter.locale = NSLocale(localeIdentifier = "en_US")
        outputFormatter.stringFromDate(date)
    } catch (e: Exception) {
        isoDate
    }
}