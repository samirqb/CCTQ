package com.tallerquiceno.cctq.views.bodies

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.NumberFormat
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.tallerquiceno.cctq.models.entities.ServicioEntidad
import com.tallerquiceno.cctq.viewmodels.MainViewModel
import com.tallerquiceno.cctq.configuraciones.navegacion.Screen
import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity
import com.tallerquiceno.cctq.viewmodels.DatosPrestadorServicioViewModel
import com.tallerquiceno.cctq.views.components.datosPrestadorServicioForm
import com.tallerquiceno.cctq.views.iAppUiState

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun InicioScreenBody(
    navController: NavController,
    mainViewModel: MainViewModel


) {

    val context = LocalContext.current
    //val mDatosPrestadorServicioViewModel: DatosPrestadorServicioViewModel = viewModel(factory = DatosPrestadorServicioViewModel.Factory)
    //val datosPrestadorServicioViewModel = DatosPrestadorServicioViewModel(DatosPrestadorServicioRepository(
    //    BasededatosApp.obtenerInstancia(context).mIDatosPrestadorServicioDao()))
    val texto_max_char = 30
    //val fechaHoraSistema = ObtenerFechaHoraSistema()
    val miAppUiState by mainViewModel.uiState.collectAsState()
    val state:LazyListState = rememberLazyListState()



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = 13.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state
    ) {

        item{
            imagenLogo()
        }


        item {
            val tipo_reporte = "Datos Prestador Servicio"
            Text(modifier = Modifier.fillMaxWidth()

                , fontSize = 31.sp
                , text = tipo_reporte
                , color = MaterialTheme.colorScheme.primary
                , fontWeight = FontWeight.Bold
                , textAlign = TextAlign.End
            )
        }


        item {
            //datosPrestadorServicioForm()
            //Spacer(modifier = Modifier.height(150.dp))
            datosPrestadorServicio()
            //datosPrestadorServicio(mDatosPrestadorServicioViewModel)
            Spacer(modifier = Modifier.height(50.dp))
        }

        item {
            val tipo_reporte = "Datos Cliente"
            Text(modifier = Modifier.fillMaxWidth()

                , fontSize = 31.sp
                , text = tipo_reporte
                , color = MaterialTheme.colorScheme.primary
                , fontWeight = FontWeight.Bold
                , textAlign = TextAlign.End
            )
        }

        item {
            FormulariuReceptorServicio(mainViewModel,texto_max_char)
            Spacer(modifier = Modifier.height(50.dp))
        }

        item {
            val tipo_reporte = "Lista de servicios"
            Text(modifier = Modifier.fillMaxWidth()

                , fontSize = 31.sp
                , text = tipo_reporte
                , color = MaterialTheme.colorScheme.primary
                , fontWeight = FontWeight.Bold
                , textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.height( 15.dp))
        }

        itemsIndexed(miAppUiState.lista_servicios_agregados) { indice, servicio ->

            if (servicio != null) {
                ListaServiciosAgregados(context,indice,mainViewModel,servicio)
            }

            Spacer(modifier = Modifier.padding(7.dp))
        }


        /*** TOTAL SUMA SERVICIOS ***/
        item {
            Text(modifier = Modifier.fillMaxWidth(), color = Color.White,
                fontSize =  (27.sp),
                text = "Total:")

            Text(modifier = Modifier.fillMaxWidth(), color = Color.White,
                fontSize =  (31.sp),
                text = NumberFormat.getCurrencyInstance().format(
                    mainViewModel.total_suma_servicios)
            )
            Spacer(modifier = Modifier.padding(50.dp))
        }


        /********************** B O T O N E S ***************************/

        item {
            btnOpen_AgregarServicioScreen(navController,miAppUiState)
            Spacer(modifier = Modifier.height(50.dp))
        }


        item{
            btnCreate_PDF(context,miAppUiState,mainViewModel)
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
fun imagenLogo() {
    Image(
        painter = painterResource(id = R.drawable.logotallerquiceno),
        contentDescription = "Logo Taller Quiceno",
        modifier = Modifier
            .size(300.dp)
            .fillMaxWidth()
    )
}

@Composable
fun datosPrestadorServicio(
    //datosPrestadorServicioViewModel: DatosPrestadorServicioViewModel
) { //esta funcion debe recivir una entidad como argumento

    //val entidad: DatosPrestadorServicioEntity = datosPrestadorServicioViewModel.leerPorPk.value!!

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
    ) {


        val ubicacion = "Cra 11 #25b-21 Pereira - Risaralda"
        //val ubicacion = entidad.ubicacion ?: "Sin especifica_r"
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = ubicacion
            ,color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)


        val telefono = "Tel/WhatsApp 323 328 3353"
        //val telefono = entidad.telefono ?: "Sin especificar_"
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = telefono
            ,color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)


        val email = "tallerquiceno@gmail.com"
        //val email = entidad.email ?: "Sin especificar_"
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = email
            , color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)


        val identificacion = "NIT: 12685008-1"
        //val identificacion = entidad.identificacion_tributaria ?: "Sin Especificar_"
        Text(modifier = Modifier.fillMaxWidth(),fontSize = 17.sp, text = identificacion
            , color = MaterialTheme.colorScheme.secondary
            , textAlign = TextAlign.End)
    }
}



@Composable
fun FormulariuReceptorServicio(mainViewModel: MainViewModel, texto_max_char: Int) {

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.nombre_cliente ,
            onValueChange = {
                if ( it.length <= texto_max_char ) mainViewModel.actualizarNombreCliente(it.uppercase())
            },
            label = { Text("Nombre del cliente") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.nombre_cliente.length} / $texto_max_char",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height( 15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.identificacion_cliente,
            onValueChange = {
                if ( it.length <= texto_max_char ) mainViewModel.actualizarIdentificacionCliente(it.uppercase())
            },
            label = { Text("Identificacion del cliente") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.identificacion_cliente.length} / $texto_max_char",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.vehiculo_marca,
            onValueChange = { if ( it.length <= texto_max_char ) mainViewModel.actualizarVehiculoMarca(it.uppercase()) },
            label = { Text("Vehiculo marca") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.vehiculo_marca.length} / $texto_max_char",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.vehiculo_modelo,
            onValueChange = { if ( it.length <= texto_max_char ) mainViewModel.actualizarVehiculoModelo(it.uppercase()) },
            label = { Text("Vehiculo modelo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.vehiculo_modelo.length} / $texto_max_char",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mainViewModel.vehiculo_matricula,
            onValueChange = { if ( it.length <= texto_max_char ) mainViewModel.actualizarVehiculoMatricula (it.uppercase()) },
            label = { Text("Vehiculo matricula") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${mainViewModel.vehiculo_matricula.length} / $texto_max_char",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
        )
    }
}



@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ListaServiciosAgregados(context:Context, indice:Int, mainViewModel: MainViewModel, servicio: ServicioEntidad){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        Toast
                            .makeText(context, "Dolble tap para eliminar!", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onDoubleTap = { dobleTap ->

                        mainViewModel.eliminarServicio(indice = indice, it = servicio)
                        mainViewModel.actualizarTotalSumaServiciosDespuesRemoverElemento()

                    })
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        shape = MaterialTheme.shapes.small

    ) {
        Column(Modifier.padding(11.dp)) {
            Text(fontSize =  (17.sp)
                ,text = "${servicio?.cantidad_unidades_de_servicio.toString()} " +
                        "${servicio?.descripcion_servicio.toString()}"
                ,color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.padding(1.5.dp))

            Text(fontSize =  (15.sp)
                ,text = "Valor unidad: ${
                    NumberFormat.getCurrencyInstance().format(servicio?.valor_unitario_servicio)
                }"
                ,color = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.padding(1.5.dp))

            Text(fontSize =  (20.sp),
                fontWeight = FontWeight.Bold,
                text = "Subtotal: ${
                    NumberFormat.getCurrencyInstance().format(servicio?.subtotal_servicio)
                }",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}



@Composable
fun btnOpen_AgregarServicioScreen(navController: NavController, miAppUiState: iAppUiState?,) {
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



@Composable
fun btnCreate_PDF(context: Context, miAppUiState: iAppUiState?, mainViewModel: MainViewModel){

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        // Manejar el resultado del permiso aquí
        mainViewModel.generarPdf(context)
        Toast.makeText(context,"PDF creado exitosamente!",Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(context,"PDF creado exitosamente!",Toast.LENGTH_SHORT).show()
                    }
                } else  {
                    Toast.makeText(context,"ERROR: No se puede crear PDF",Toast.LENGTH_SHORT).show()
                }
            },

            ) {
            Text("PDF ")
            Icon(imageVector = Icons.Sharp.Create , contentDescription = "")
        }
    }
}



@RequiresApi(Build.VERSION_CODES.R)
@Composable
@Preview(showBackground = true)
fun InicioScreenBodyPreview(){
    InicioScreenBody(
        navController = rememberNavController(),
        viewModel(),
    )
}
