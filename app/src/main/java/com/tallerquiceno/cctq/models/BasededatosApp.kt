package com.tallerquiceno.cctq.models

import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity

class BasededatosApp(

    //val mDatosPrestadorServicioDao: DatosPrestadorServicioDao = DatosPrestadorServicioDao(this.obtenerInstancia())

) {
    companion object {

        private var _instance:List<DatosPrestadorServicioEntity> = listOf(
            DatosPrestadorServicioEntity(
                primary_key = 1,
                nombre = "Taller Quiceno",
                email = "tallerquiceno@gamil.com",
                telefono = "3233283353",
                ubicacion = "Cra 11 #25b-21 Pereira - Risaralda",
                identificacion_tributaria = "7776667667"
            )
        )

        fun obtenerInstancia():List<DatosPrestadorServicioEntity> {
            return _instance
        }
    }
}