package com.tallerquiceno.cctq.views

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tallerquiceno.cctq.configuraciones.navegacion.SetupNavGraph
import com.tallerquiceno.cctq.views.ui.theme.CCTQTheme

class MainActivity : ComponentActivity() {

    lateinit var navControlller: NavHostController

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CCTQTheme {
                navControlller = rememberNavController()
                SetupNavGraph(navController = navControlller)
            }
        }
    }
}