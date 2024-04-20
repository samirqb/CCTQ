package com.tallerquiceno.cctq.views.bodies

import android.content.Context
import android.icu.text.NumberFormat
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tallerquiceno.cctq.R
import com.tallerquiceno.cctq.viewmodels.MainViewModel

import java.io.IOException

@Composable
fun AgregarServicioScreenBody(navController: NavController,
                              mainViewModel: MainViewModel
){

    val numero_regex = Regex("[0-9]+")
    val context = LocalContext.current
    val state: LazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = 13.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state

    ){

        item{
            Text(
                text = "Nuevo servicio",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(modifier = Modifier.height(50.dp))
        }


        item{
            formularioAgregarServicio(context=context,
                mainViewModel = mainViewModel,
                numero_regex = numero_regex
            )

            Spacer(modifier = Modifier.height(50.dp))
        }


        item{
            btnsMakeCancel_Servicio(
                navController = navController,
                mainViewModel = mainViewModel,
                context = context)
        }
    }
}



@Composable
fun formularioAgregarServicio(
    context:Context,
    mainViewModel: MainViewModel,
    numero_regex: Regex
) {

    val texto_max_char = 30
    val numero_max_char_1 = 3
    val numero_max_char_2 = 7

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 13.dp)) {

        /** cantidad_unidades_de_servicio **/
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.cantidad_unidades_de_servicio.toString() ,
            onValueChange = {input ->
                try {
                    if((input.matches(numero_regex)) && (input.length <= numero_max_char_1)) {
                        mainViewModel.actualizarCantidadUnidadesDeServicio(input)
                    }
                    if(input.isEmpty()) {
                        mainViewModel.actualizarCantidadUnidadesDeServicio("")
                    }
                } catch (e:Exception){
                    Toast.makeText(context, "Igrese solo numeros", Toast.LENGTH_SHORT).show()
                    Log.d("TAG","ERROR-E: ${e.stackTrace}")
                }catch (ioe: IOException){
                    Toast.makeText(context, "Igrese solo numeros", Toast.LENGTH_SHORT).show()
                    Log.d("TAG","ERROR-IOE: ${ioe.stackTrace}")
                }
            },
            label = { Text("Cantidad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.cantidad_unidades_de_servicio.toString().length} / $numero_max_char_1",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        /** descripcion_servicio **/
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.descripcion_servicio,
            onValueChange = {
                if ( it.length <= texto_max_char ) mainViewModel.actualizarDescripcionServicio(it.uppercase())
                },
            label = { Text("Descripcion servicio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.descripcion_servicio.length} / $texto_max_char",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))


        /** valor_unitario_servicio **/
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.valor_unitario_servicio.toString(),
            onValueChange = {input ->

                try {
                    if((input.matches(numero_regex)) && (input.length <= numero_max_char_2)) {
                        mainViewModel.actualizarValorUnitarioServicio(input)
                    }
                    if(input.isEmpty()) {
                        mainViewModel.actualizarValorUnitarioServicio("")
                    }
                } catch (e:Exception){
                    Toast.makeText(context, "Igrese solo numeros", Toast.LENGTH_SHORT).show()
                    Log.d("TAG","ERROR-E: ${e.stackTrace}")
                }catch (ioe: IOException){
                    Toast.makeText(context, "Igrese solo numeros", Toast.LENGTH_SHORT).show()
                    Log.d("TAG","ERROR-IOE: ${ioe.stackTrace}")
                }},
            label = { Text("Valor servicio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.valor_unitario_servicio.length} / $numero_max_char_2",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        /** subtotal_servicio */
        Text(
            fontSize =  (27.sp),
            text = stringResource(R.string.subtotal ),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
        )
        Text(
            fontSize =  (31.sp),
            text = NumberFormat.getCurrencyInstance().format(
                mainViewModel.subtotal_servicio),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
        )
    }
}


@Composable
fun btnsMakeCancel_Servicio(navController: NavController,
                            mainViewModel: MainViewModel,
                            context: Context
) {
    /** BOTON Agregar Servicio **/


    Box(
        contentAlignment = Alignment.TopCenter,
    ){
        Row() {

            OutlinedButton(onClick = { navController.popBackStack() },Modifier.size(136.dp,49.dp)
            ) {
                Text(
                    text = "Cancelar"
                )
                Icon(imageVector = Icons.Default.Close, contentDescription = "")
            }
            
            Spacer(modifier = Modifier.size(27.dp))

            Button(onClick = { mainViewModel.actualizarFechaHora()
                if (mainViewModel.validarCampos_Formulario_AgregarServicios()) {
                    /** se vacian los textfields antes de retornar a la pantalla pricipal **/
                    mainViewModel.actualizarCantidadUnidadesDeServicio("")
                    mainViewModel.actualizarDescripcionServicio("")
                    mainViewModel.actualizarValorUnitarioServicio("")
                    mainViewModel.actualizarSubtotal()

                    navController.popBackStack() //sería "similar" a: navController.navigate(route = Screen.HomeScreen.path_screen)
                } else{
                    Toast.makeText(context,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show()
                }
            }
                ,Modifier.size(136.dp,49.dp)
                ) {
                Text("Crear")
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AgregarServicioScreenBodyPreview(){
    AgregarServicioScreenBody(
        navController = rememberNavController(),
        viewModel()
    )
}
