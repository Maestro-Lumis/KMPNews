package com.example.kmpfirstnews

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

actual fun getCurrentDate(): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return formatter.format(Date())
}