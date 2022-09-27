package com.example.preferencedatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider

import com.example.preferencedatastore.databinding.ActivityMainBinding
import com.example.preferencedatastore.util.Utils.datastore
import com.example.preferencedatastore.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val vm:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        vm.getData()
        binding.apply {
            btnSave.setOnClickListener {
                val name = edtName.text.toString()
                val phone = edtPhone.text.toString()
                val address = edtAddress.text.toString()
                vm.saveData(name, phone, address)
            }

            vm.phoneBook.observe(this@MainActivity) { data ->
                txtName.text = data.name
                txtAddress.text = data.address
                txtPhone.text = data.phone
            }
            btnGetData.setOnClickListener {
                vm.deleteData()
            }
        }
    }
}