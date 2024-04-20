package com.tallerquiceno.cctq.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tallerquiceno.cctq.models.BasededatosApp
import com.tallerquiceno.cctq.models.daos.DatosPrestadorServicioDao
import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity
import com.tallerquiceno.cctq.repositories.DatosPrestadorServicioRepository

class DatosPrestadorServicioViewModel(
    private val mDatosPrestadorServicioRepository: DatosPrestadorServicioRepository,
): ViewModel() {

    //var primary_key: String by mutableStateOf("")
    //    private set

    var identificacion_tributaria: String by mutableStateOf("")
        private set

    var nombre: String by mutableStateOf("")
        private set

    var ubicacion: String by mutableStateOf("")
        private set

    var telefono: String by mutableStateOf("")
        private set

    var email: String by mutableStateOf("")
        private set



    fun actualizarIdentificacionTributaria(it: String){
        identificacion_tributaria = it
    }

    fun actualizarNombre(it: String){
        nombre = it
    }

    fun actualizarUbicacion(it: String){
        ubicacion = it
    }

    fun actualizarTelefono(it: String){
        telefono = it
    }

    fun actualizarEmail(it: String){
        email = it
    }



    /*
    fun crear(entidad: DatosPrestadorServicioEntity){
        viewModelScope.launch(Dispatchers.IO) {
            mDatosPrestadorServicioRepository.crear(entidad)
        }
    }
    */

    val leerPorPk: LiveData<DatosPrestadorServicioEntity?> = mDatosPrestadorServicioRepository.leerPorPk(1).asLiveData()

    /*
    val leerTodosAsc: LiveData<List<DatosPrestadorServicioEntity>> = mDatosPrestadorServicioRepository.leerTodosAsc().asLiveData()

    fun actualizar(entidad: DatosPrestadorServicioEntity){
        viewModelScope.launch(Dispatchers.IO) {
            mDatosPrestadorServicioRepository.actualizar(entidad)
        }
    }

    fun eliminar(entidad: DatosPrestadorServicioEntity){
        viewModelScope.launch(Dispatchers.IO) {
            mDatosPrestadorServicioRepository.eliminar(entidad)
        }
    }
    */

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                //val savedStateHandle = createSavedStateHandle()
                val db = BasededatosApp
                val myRepository = (DatosPrestadorServicioRepository(DatosPrestadorServicioDao(db.obtenerInstancia())))
                //val myRepository = (ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY as MainApplication).container.mDatosPrestadorServicioRepository
                DatosPrestadorServicioViewModel(
                    mDatosPrestadorServicioRepository = myRepository,
                )
            }
        }
    }
}