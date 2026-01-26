package com.zyphir.messaging.realtimeapp.shared.manager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenManager @Inject constructor(private val dataStore : DataStore<Preferences>) {

    val accessToken = dataStore.data.map { it[ACCESS_KEY] ?: "" }
    val refreshToken = dataStore.data.map { it[REFRESH_KEY] ?: "" }

    suspend fun save(access: String, refresh: String) {
        dataStore.edit {
            it[ACCESS_KEY] = access
            it[REFRESH_KEY] = refresh
        }
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }

    companion object {
        val ACCESS_KEY = stringPreferencesKey("access")
        val REFRESH_KEY = stringPreferencesKey("refresh")
    }
}