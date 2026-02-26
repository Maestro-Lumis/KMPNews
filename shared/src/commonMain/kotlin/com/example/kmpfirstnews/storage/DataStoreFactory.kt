package com.example.kmpfirstnews.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal const val dataStoreFileName = "news.preferences_pb"

expect fun createDataStore(): DataStore<Preferences>

class NewsDataStore(
    private val store: DataStore<Preferences>
) {
    companion object {
        val FAVORITES_KEY = stringSetPreferencesKey("favorites")
    }

    suspend fun addFavorite(newsId: String) {
        store.edit { prefs ->
            val current = prefs[FAVORITES_KEY] ?: emptySet()
            prefs[FAVORITES_KEY] = current + newsId
        }
    }

    suspend fun removeFavorite(newsId: String) {
        store.edit { prefs ->
            val current = prefs[FAVORITES_KEY] ?: emptySet()
            prefs[FAVORITES_KEY] = current - newsId
        }
    }

    val favorites: Flow<Set<String>> = store.data.map { prefs ->
        prefs[FAVORITES_KEY] ?: emptySet()
    }
}