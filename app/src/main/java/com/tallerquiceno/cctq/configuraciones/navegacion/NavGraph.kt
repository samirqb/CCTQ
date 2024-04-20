package com.tallerquiceno.cctq.configuraciones.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tallerquiceno.cctq.viewmodels.DatosPrestadorServicioViewModel
import com.tallerquiceno.cctq.viewmodels.MainViewModel
import com.tallerquiceno.cctq.views.screens.AgregarDatosProveedorServicioScreen
import com.tallerquiceno.cctq.views.screens.AgregarServicioScreen
import com.tallerquiceno.cctq.views.screens.InicioScreen

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    MainViewModel: MainViewModel = viewModel(),
){
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.path_screen
        ){

        composable(route = Screen.HomeScreen.path_screen){
            InicioScreen(navController,MainViewModel)
        }

        composable(route = Screen.AgregarServicioScreen.path_screen){
            AgregarServicioScreen(navController,MainViewModel)
        }

        composable(route = Screen.AgregarDatosProveedorServicioScreen.path_screen){
            AgregarDatosProveedorServicioScreen(navController,MainViewModel)
        }
    }
}