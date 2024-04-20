package com.tallerquiceno.cctq.views.components

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.NumberFormat
import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tallerquiceno.cctq.models.entities.ServicioEntidad
import com.tallerquiceno.cctq.viewmodels.MainViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ListaServiciosAgregados(context: Context, indice:Int, mainViewModel: MainViewModel, servicio: ServicioEntidad){

    val VALOR_UNIDAD_LABEL = "Valor unidad: "
    val SUBTOTAL_LABEL = "Subtotal: "


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        Toast.makeText(context,"Dolble tap para eliminar!", Toast.LENGTH_LONG).show()
                    },
                    onDoubleTap = { dobleTap ->

                        mainViewModel.eliminarServicio(indice = indice, it = servicio)
                        mainViewModel.actualizarTotalSumaServiciosDespuesRemoverElemento()

                    })
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        shape = MaterialTheme.shapes.small

    ) {
        Column(Modifier.padding(11.dp)) {
            Text(fontSize =  (17.sp)
                ,text = "${servicio?.cantidad_unidades_de_servicio.toString()} " +
                        "${servicio?.descripcion_servicio.toString()}"
                ,color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.padding(1.5.dp))


            Text(fontSize =  (15.sp)
                ,text = "${VALOR_UNIDAD_LABEL} ${
                    NumberFormat.getCurrencyInstance().format(servicio?.valor_unitario_servicio)
                }"
                ,color = MaterialTheme.colorScheme.tertiary)

            Spacer(modifier = Modifier.padding(1.5.dp))

            Text(fontSize =  (20.sp),
                fontWeight = FontWeight.Bold,
                text = "${SUBTOTAL_LABEL} ${
                    NumberFormat.getCurrencyInstance().format(servicio?.subtotal_servicio)
                }",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}