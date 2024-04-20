package com.tallerquiceno.cctq.views.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tallerquiceno.cctq.viewmodels.MainViewModel
import com.tallerquiceno.cctq.views.bodies.InicioScreenBody


@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun InicioScreen(
    navController: NavController,
    //mainViewModel: MainViewModel = viewModel(),
    mainViewModel: MainViewModel,
){
    InicioScreenBody(
        navController = navController,
        mainViewModel = mainViewModel,
    )
}
