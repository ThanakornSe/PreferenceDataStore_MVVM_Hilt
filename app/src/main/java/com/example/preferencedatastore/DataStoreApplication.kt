package com.example.preferencedatastore

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DataStoreApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}