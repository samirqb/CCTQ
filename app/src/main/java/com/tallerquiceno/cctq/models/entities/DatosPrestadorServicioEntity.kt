package com.tallerquiceno.cctq.models.entities

data class DatosPrestadorServicioEntity(

    val primary_key: Int = 0,

    val identificacion_tributaria: String,

    val nombre: String,

    val ubicacion: String,

    val telefono: String,

    val email: String,

)