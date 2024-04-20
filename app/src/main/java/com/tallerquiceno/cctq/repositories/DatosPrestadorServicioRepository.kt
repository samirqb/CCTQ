package com.tallerquiceno.cctq.repositories

import androidx.annotation.WorkerThread
import com.tallerquiceno.cctq.models.daos.IDatosPrestadorServicioDao
import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity
import kotlinx.coroutines.flow.Flow

class DatosPrestadorServicioRepository(private val dao: IDatosPrestadorServicioDao):IBaseRepository<DatosPrestadorServicioEntity> {

    /*
    override suspend fun crear(entidad: DatosPrestadorServicioEntity) {
        dao.crear(entidad)
    }
    */

    override fun leerPorPk(pk: Int): Flow<DatosPrestadorServicioEntity?> = dao.leerPorPk(pk)

    /*
    override fun leerTodosAsc(): Flow<List<DatosPrestadorServicioEntity>> {
        return dao.leerTodosAsc()
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun actualizar(entidad: DatosPrestadorServicioEntity) {
        dao.actualizar(entidad)
    }

    override suspend fun eliminar(entidad: DatosPrestadorServicioEntity) {
        dao.eliminar(entidad)
    }
    */

}