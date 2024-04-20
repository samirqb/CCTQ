package com.tallerquiceno.cctq.views.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tallerquiceno.cctq.viewmodels.MainViewModel
import com.tallerquiceno.cctq.views.bodies.AgregarServicioScreenBody

@Composable
fun AgregarServicioScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
) {

    AgregarServicioScreenBody(
        navController = navController,
        mainViewModel = mainViewModel
    )
}
