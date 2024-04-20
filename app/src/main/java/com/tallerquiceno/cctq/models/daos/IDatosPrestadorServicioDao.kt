package com.tallerquiceno.cctq.models.daos

import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity
import kotlinx.coroutines.flow.Flow

interface IDatosPrestadorServicioDao {

    fun leerPorPk(pk: Int):Flow<DatosPrestadorServicioEntity>

}
