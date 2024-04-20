package com.tallerquiceno.cctq.helpers

import com.tallerquiceno.cctq.models.entities.ServicioEntidad

class OperacionesMetematicas {

    fun calcularSubtotal(cantidad:Int, valor_unitario:Int):Int{

        return cantidad * valor_unitario

    }



    fun sumarTodosLosServicios(lista_subtotales: List<ServicioEntidad?>):Int{

        var total_suma: Int = 0

        //for (mServicioEntidad in lista_subtotales) total_suma += mServicioEntidad?.subtotal_servicio
        lista_subtotales.forEach {
            total_suma += it!!.subtotal_servicio
        }

        return total_suma
    }
}