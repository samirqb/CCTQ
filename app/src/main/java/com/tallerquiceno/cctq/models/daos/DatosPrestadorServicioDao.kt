package com.tallerquiceno.cctq.models.daos

import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DatosPrestadorServicioDao(private val db:List<DatosPrestadorServicioEntity>): IDatosPrestadorServicioDao {

    override fun leerPorPk(pk: Int): Flow<DatosPrestadorServicioEntity> {
        return flow { db.get(0) }
    }

}