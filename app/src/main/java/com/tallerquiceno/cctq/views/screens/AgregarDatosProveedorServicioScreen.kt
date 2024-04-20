package com.tallerquiceno.cctq.views.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tallerquiceno.cctq.viewmodels.MainViewModel
import com.tallerquiceno.cctq.views.bodies.AgregarDatosProveedorServicioScreenBody

@Composable
fun AgregarDatosProveedorServicioScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
) {

    AgregarDatosProveedorServicioScreenBody(
        navController = navController,
        mainViewModel = mainViewModel
    )
}
