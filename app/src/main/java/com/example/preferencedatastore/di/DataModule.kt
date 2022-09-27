package com.example.preferencedatastore.di

import android.content.Context
import com.example.preferencedatastore.repository.PhoneBookRepository
import com.example.preferencedatastore.repository.PhoneBookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context):PhoneBookRepository {
        return PhoneBookRepositoryImpl(context)
    }
}