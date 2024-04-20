package com.tallerquiceno.cctq.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tallerquiceno.cctq.viewmodels.DatosPrestadorServicioViewModel

@Composable
fun datosPrestadorServicioForm(
    mDatosPrestadorServicioViewModel: DatosPrestadorServicioViewModel = viewModel(factory = DatosPrestadorServicioViewModel.Factory)
){

    val TEXTO_MAX_CHAR = 30

    val IDENTIFICACION_TRIBUTARIA = "***Identificacion tributaria"
    val NOMBRE = "***Nombre"
    val UBICACION = "***Ubicacion"
    val TELEFONO = "***Telefono"
    val EMAIL = "***Email"

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mDatosPrestadorServicioViewModel.identificacion_tributaria,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mDatosPrestadorServicioViewModel.actualizarIdentificacionTributaria(it.uppercase())
            },
            label = { Text(IDENTIFICACION_TRIBUTARIA) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mDatosPrestadorServicioViewModel.identificacion_tributaria.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mDatosPrestadorServicioViewModel.nombre,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mDatosPrestadorServicioViewModel.actualizarNombre(it.uppercase())
            },
            label = { Text(NOMBRE) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mDatosPrestadorServicioViewModel.identificacion_tributaria.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mDatosPrestadorServicioViewModel.ubicacion,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mDatosPrestadorServicioViewModel.actualizarUbicacion(it.uppercase())
            },
            label = { Text(UBICACION) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mDatosPrestadorServicioViewModel.identificacion_tributaria.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mDatosPrestadorServicioViewModel.telefono,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mDatosPrestadorServicioViewModel.actualizarTelefono(it.uppercase())
            },
            label = { Text(TELEFONO) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mDatosPrestadorServicioViewModel.telefono.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mDatosPrestadorServicioViewModel.email,
            onValueChange = {
                if ( it.length <= TEXTO_MAX_CHAR ) mDatosPrestadorServicioViewModel.actualizarEmail(it.uppercase())
            },
            label = { Text(EMAIL) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mDatosPrestadorServicioViewModel.identificacion_tributaria.length} / $TEXTO_MAX_CHAR",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )
    }
}