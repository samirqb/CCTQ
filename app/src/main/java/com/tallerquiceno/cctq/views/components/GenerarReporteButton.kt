package com.tallerquiceno.cctq.views.components

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tallerquiceno.cctq.viewmodels.MainViewModel
import com.tallerquiceno.cctq.views.iAppUiState

@Composable
fun GenerarReporteButton(context: Context, miAppUiState: iAppUiState?, mainViewModel: MainViewModel){

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        // Manejar el resultado del permiso aquí
        mainViewModel.generarPdf(context)
        Toast.makeText(context,"PDF creado exitosamente!",Toast.LENGTH_LONG).show()
    }

    /** si la lista del servicios agregados esta vacia, se oculta el boton de crear pdf **/
    if (miAppUiState?.lista_servicios_agregados?.size!! > 0){
        OutlinedButton(modifier = Modifier.size(196.dp,59.dp),
            onClick = {

                if (miAppUiState?.lista_servicios_agregados?.size != 0){
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R){
                        requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    } else {
                        //var pdf = GenerarPdf(miAppUiState?.lista_servicios_agregados.toList(),mainViewModel,context)
                        //pdf.generar()
                        mainViewModel.generarPdf(context)
                        Toast.makeText(context,"PDF creado exitosamente!",Toast.LENGTH_LONG).show()
                    }
                } else  {
                    Toast.makeText(context,"ERROR: No se puede crear PDF",Toast.LENGTH_LONG).show()
                }
            },

            ) {
            Text("PDF ")
            Icon(imageVector = Icons.Sharp.Create , contentDescription = "")
        }
    }
}
