package com.tallerquiceno.cctq.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity


@Composable
fun datosPrestadorServicioSection(entidad:DatosPrestadorServicioEntity) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
    ) {

        /*
        val tipo_reporte = "CUENTA DE COBRO"
        Text(modifier = Modifier.fillMaxWidth()

            , fontSize = 31.sp
            , text = tipo_reporte
            , color = MaterialTheme.colorScheme.primary
            , fontWeight = FontWeight.Bold
            , textAlign = TextAlign.End
        )
        */


        val nombre = entidad.nombre
        Text(
            modifier = Modifier.fillMaxWidth(),
            fontSize = 17.sp ,
            text = nombre,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.End
        )


        val ubicacion = entidad.ubicacion
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = ubicacion
            ,color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)


        val telefono = entidad.telefono
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = telefono
            ,color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)


        val email = entidad.email
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = email
            , color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)


        val identificacion = entidad.identificacion_tributaria
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = identificacion
            , color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)

    }

}
