package com.example.preferencedatastore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preferencedatastore.model.PhoneBook
import com.example.preferencedatastore.repository.PhoneBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PhoneBookRepository) : ViewModel() {

    private var _phoneBook = MutableLiveData<PhoneBook>()
    val phoneBook: LiveData<PhoneBook> get() = _phoneBook

    fun saveData(name: String, phone: String, address: String) = viewModelScope.launch {
        repository.savePhoneBook(
            PhoneBook(name, address, phone)
        )
    }

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        repository.getPhoneBook().collect {
            _phoneBook.postValue(it)
        }
    }

    fun deleteData() = viewModelScope.launch {
        repository.deleteData()
    }


}