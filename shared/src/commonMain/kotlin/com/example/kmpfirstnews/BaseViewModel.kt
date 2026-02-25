package com.example.kmpfirstnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

open class BaseViewModel : ViewModel() {
    val scope: CoroutineScope = viewModelScope
}