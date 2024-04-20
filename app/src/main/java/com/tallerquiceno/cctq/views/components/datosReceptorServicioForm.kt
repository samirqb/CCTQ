package com.tallerquiceno.cctq.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tallerquiceno.cctq.viewmodels.MainViewModel


@Composable
fun datosReceptorServicioForm(mainViewModel: MainViewModel) {

    val TEXTO_MAX_CHAR = 30
    val NOMBRE_CLIENTE_LABEL = "Nombre del cliente"
    val IDENTIFICACION_CLIENTE_LABEL = "Identificacion del cliente"
    val VEHICULO_MARCA_LABEL = "Vehiculo marca"
    val VEHICULO_MOD_LABEL = "Vehiculo modelo"
    val VEHICULO_MATRICULA_LABEL = "Vehiculo matricula"

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.nombre_cliente,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mainViewModel.actualizarNombreCliente(it.uppercase())
            },
            label = { Text(NOMBRE_CLIENTE_LABEL) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.nombre_cliente.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height( 15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.identificacion_cliente,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mainViewModel.actualizarIdentificacionCliente(it.uppercase())
            },
            label = { Text(IDENTIFICACION_CLIENTE_LABEL) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.identificacion_cliente.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.vehiculo_marca,
            onValueChange = { if ( it.length <= TEXTO_MAX_CHAR ) mainViewModel.actualizarVehiculoMarca(it.uppercase()) },
            label = { Text(VEHICULO_MARCA_LABEL) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.vehiculo_marca.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.vehiculo_modelo,
            onValueChange = { if ( it.length <= TEXTO_MAX_CHAR ) mainViewModel.actualizarVehiculoModelo(it.uppercase()) },
            label = { Text(VEHICULO_MOD_LABEL) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.vehiculo_modelo.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.vehiculo_matricula,
            onValueChange = { if ( it.length <= TEXTO_MAX_CHAR ) mainViewModel.actualizarVehiculoMatricula (it.uppercase()) },
            label = { Text(VEHICULO_MATRICULA_LABEL) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.vehiculo_matricula.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )
    }
}