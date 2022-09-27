package com.example.preferencedatastore.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


object Utils {

    private const val DATASTORE_NAME = "PHONEBOOK"

    val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)

    val NAME = stringPreferencesKey("NAME")
    val PHONE_NUMBER = stringPreferencesKey("PHONE")
    val ADDRESS = stringPreferencesKey("ADDRESS")

}