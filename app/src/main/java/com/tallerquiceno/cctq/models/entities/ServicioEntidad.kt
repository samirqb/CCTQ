package com.tallerquiceno.cctq.models.entities

data class ServicioEntidad(
    var fecha_hora_creacion_servicio: String,
    var cantidad_unidades_de_servicio: Int,
    var descripcion_servicio: String,
    var valor_unitario_servicio: Int,
    var subtotal_servicio: Int,
)