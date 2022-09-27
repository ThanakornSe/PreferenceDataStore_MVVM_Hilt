package com.example.preferencedatastore.repository

import com.example.preferencedatastore.model.PhoneBook
import kotlinx.coroutines.flow.Flow

interface PhoneBookRepository {

    suspend fun savePhoneBook(phoneBook: PhoneBook)

    suspend fun getPhoneBook():Flow<PhoneBook>

    suspend fun deleteData()

}