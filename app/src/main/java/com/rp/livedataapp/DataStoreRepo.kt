package com.rp.livedataapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Property delegate creates a single singleton DataStore instance associated with Context
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")

class DataStoreRepo(private val context: Context) {
    val dataStore: DataStore<Preferences> = context.dataStore

    suspend fun saveData(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)

        val dataStore1 = context.dataStore
        dataStore1.edit { preferences ->
            preferences[prefKey] = value
        }
    }

    fun getData(key: String, defaultValue: String): Flow<String> {
        val prefKey = stringPreferencesKey(key)

        val dataStore1 = context.dataStore
        val data = dataStore1.data
        return data.map { preferences ->
            preferences[prefKey] ?: defaultValue
        }
    }

    fun getBooleanData(key: String, defaultValue: Boolean): Flow<Boolean> {
        val prefKey = booleanPreferencesKey(key)
        return context.dataStore.data.map { preferences ->
            preferences[prefKey] ?: defaultValue
        }
    }
}