package com.guzman.telefonotracker.data.repositories

import com.guzman.telefonotracker.data.models.TelefonoModel

class RepositoryTelefono(private var telefonos: MutableList<TelefonoModel>) {

    fun getTelefonos() = telefonos

    fun addTelefono(newTelefono: TelefonoModel) = telefonos.add(newTelefono)
}