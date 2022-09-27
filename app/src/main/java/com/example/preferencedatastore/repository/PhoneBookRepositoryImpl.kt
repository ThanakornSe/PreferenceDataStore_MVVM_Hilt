package com.example.preferencedatastore.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.preferencedatastore.model.PhoneBook
import com.example.preferencedatastore.util.Utils.ADDRESS
import com.example.preferencedatastore.util.Utils.NAME
import com.example.preferencedatastore.util.Utils.PHONE_NUMBER
import com.example.preferencedatastore.util.Utils.datastore
import kotlinx.coroutines.flow.map

class PhoneBookRepositoryImpl (private val context:Context) : PhoneBookRepository {

    override suspend fun savePhoneBook(phoneBook: PhoneBook) {
        context.datastore.edit { phonebooks ->
            phonebooks[NAME] = phoneBook.name
            phonebooks[PHONE_NUMBER] = phoneBook.phone
            phonebooks[ADDRESS] = phoneBook.address
        }
    }

    override suspend fun getPhoneBook() = context.datastore.data.map { phonebook ->
        PhoneBook(name = phonebook[NAME]?:"Name",
            phone = phonebook[PHONE_NUMBER]?:"Phone Number",
            address = phonebook[ADDRESS]?:"Address"
        )
    }

    override suspend fun deleteData() {
        context.datastore.edit {
            it.clear()
        }
    }
}