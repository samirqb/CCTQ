package com.tallerquiceno.cctq.views.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tallerquiceno.cctq.configuraciones.navegacion.Screen
import com.tallerquiceno.cctq.views.iAppUiState

@Composable
fun AbrirAgregarServicioScreenButton(navController: NavController, miAppUiState: iAppUiState?,) {
    /** BTN: Agregar servicio **/

    if (miAppUiState?.lista_servicios_agregados?.size!! <= 19) {
        Button(onClick = {
            navController.navigate(route = Screen.AgregarServicioScreen.path_screen)
        }, Modifier.size(196.dp, 59.dp)
        ) {
            Text("Agregar servicio")
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
        }
    }
}