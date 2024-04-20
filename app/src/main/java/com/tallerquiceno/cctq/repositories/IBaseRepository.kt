package com.tallerquiceno.cctq.repositories

import kotlinx.coroutines.flow.Flow

interface IBaseRepository<Entidad> {
    //suspend fun crear(entidad: Entidad)
    fun leerPorPk(pk: Int):Flow<Entidad?>
    //fun leerTodosAsc(): Flow<List<Entidad>>
    //suspend fun actualizar(entidad: Entidad)
    //suspend fun eliminar(entidad: Entidad)
}