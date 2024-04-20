package com.tallerquiceno.cctq.views

import androidx.compose.runtime.mutableStateListOf
import com.tallerquiceno.cctq.models.entities.ServicioEntidad

data class iAppUiState(

    //val subtotal_servicio: Number = 0,

    val lista_servicios_agregados: MutableList<ServicioEntidad?> = mutableStateListOf()
    )