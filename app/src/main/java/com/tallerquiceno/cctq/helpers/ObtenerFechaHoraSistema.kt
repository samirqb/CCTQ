package com.tallerquiceno.cctq.helpers

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class ObtenerFechaHoraSistema {

    @SuppressLint("SimpleDateFormat")
    fun obtener():String {

        //val formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ms", Locale.ENGLISH)
        val formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ms", Locale.ENGLISH)
        val fecha_hora = LocalDateTime.now().format(formato)

        return fecha_hora
    }
}