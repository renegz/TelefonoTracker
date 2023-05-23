package com.guzman.telefonotracker

import android.app.Application
import com.guzman.telefonotracker.data.repositories.RepositoryTelefono
import com.guzman.telefonotracker.data.telefonos

class TelefonoTrackerApplication: Application() {
    val repositoryTelefono: RepositoryTelefono by lazy {
        RepositoryTelefono(telefonos)
    }
}