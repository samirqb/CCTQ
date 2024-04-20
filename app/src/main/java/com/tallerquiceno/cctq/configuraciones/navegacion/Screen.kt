package com.tallerquiceno.cctq.configuraciones.navegacion

sealed class Screen(val path_screen : String) {
    object HomeScreen: Screen(path_screen = "home_screen")
    object AgregarServicioScreen: Screen(path_screen = "agregar_servicio_screen")
    object AgregarDatosProveedorServicioScreen: Screen(path_screen = "agregar_datos_proveedor_servicio_screen")
}