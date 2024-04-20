package com.tallerquiceno.cctq.models.entities

data class ReporteEntity(
    val fecha_hora_generacion_reporte: String,
    val tipo_reporte: String,
    val total_suma_servicios: Int,
    val mDatosPrestadorServicioEntity: DatosPrestadorServicioEntity,
    val mDatosReceptorServicioEntity: DatosReceptorServicioEntity,
    val lista_servicios_agregados: List<ServicioEntidad?>,
)