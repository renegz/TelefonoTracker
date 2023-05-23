package com.guzman.telefonotracker.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guzman.telefonotracker.TelefonoTrackerApplication
import com.guzman.telefonotracker.data.models.TelefonoModel
import com.guzman.telefonotracker.data.repositories.RepositoryTelefono

class PhoneViewModel(private val repositoryTelefono: RepositoryTelefono): ViewModel() {

    val marca = MutableLiveData("")
    val modelo = MutableLiveData("")

    fun getPhones() = repositoryTelefono.getTelefonos()

    private fun addPhone(newPhone: TelefonoModel) = repositoryTelefono.addTelefono(newPhone)

    fun CreatePhone(){
        val newPhone = TelefonoModel(
            marca.value.toString(),
            modelo.value.toString()
        )

        addPhone(newPhone)
        Log.d("APP TAG", getPhones().toString())
    }

    fun clearData(){
        marca.value = ""
        modelo.value = ""
    }

    fun SetSelectedPhone(phone: TelefonoModel){
        marca.value = phone.marca
        modelo.value = phone.modelo
    }


    //Factory del viewModel para que pueda recibir argumentos
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TelefonoTrackerApplication
                PhoneViewModel(app.repositoryTelefono)
            }
        }
    }
}