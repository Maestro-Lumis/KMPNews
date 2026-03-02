package com.example.kmpfirstnews

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

actual fun getCurrentDate(): String {
    return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
}

actual fun formatNewsDate(isoDate: String): String {
    return try {
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        val output = SimpleDateFormat("d MMM yyyy", Locale.ENGLISH)
        val date = input.parse(isoDate)
        output.format(date ?: return isoDate)
    } catch (e: Exception) {
        isoDate
    }
}