package com.tallerquiceno.cctq.viewmodels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallerquiceno.cctq.helpers.GenerarPdf
import com.tallerquiceno.cctq.helpers.ObtenerFechaHoraSistema
import com.tallerquiceno.cctq.helpers.OperacionesMetematicas
import com.tallerquiceno.cctq.models.entities.DatosPrestadorServicioEntity
import com.tallerquiceno.cctq.models.entities.DatosReceptorServicioEntity
import com.tallerquiceno.cctq.models.entities.ReporteEntity
import com.tallerquiceno.cctq.models.entities.ServicioEntidad
import com.tallerquiceno.cctq.views.iAppUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {

    /******************* UI State *****************************/
    private val _uiState = MutableStateFlow(iAppUiState())
    val uiState: StateFlow<iAppUiState> = _uiState.asStateFlow()
    /**********************************************************/


    var fecha_hora: String by mutableStateOf("")
        private set

    var cantidad_unidades_de_servicio: String by mutableStateOf("")
        private set

    var descripcion_servicio :String by mutableStateOf("")
        private set

    var valor_unitario_servicio:String by mutableStateOf("")
        private set

    var subtotal_servicio: Int by mutableStateOf(0)
        private set


    /* ***CAMPOS FORMULARIO DE CLIENTES******************************* */

    var nombre_cliente: String by mutableStateOf("")
        private set

    fun actualizarNombreCliente(it: String){
        nombre_cliente = it
    }

    var identificacion_cliente: String by mutableStateOf("")
        private set

    fun actualizarIdentificacionCliente(it: String){
        identificacion_cliente = it
    }



    var vehiculo_marca: String by mutableStateOf("")
        private set



    fun actualizarVehiculoMarca(it: String){
        vehiculo_marca = it
    }



    var vehiculo_modelo: String by mutableStateOf("")
        private set

    fun actualizarVehiculoModelo(it: String){
        vehiculo_modelo = it
    }



    var vehiculo_matricula: String by mutableStateOf("")
        private set

    fun actualizarVehiculoMatricula(it: String){
        vehiculo_matricula = it
    }

    var total_suma_servicios: Int by mutableStateOf(0)
        private set

    fun actualizarTotalSumaServicios(it: ServicioEntidad?){
        total_suma_servicios += it!!.subtotal_servicio
    }

    fun actualizarTotalSumaServiciosDespuesRemoverElemento(){
        total_suma_servicios = OperacionesMetematicas().sumarTodosLosServicios(
            _uiState.value.lista_servicios_agregados.toList()
        )
    }


    /* ****************************************************************** */


    /** se obtiene fecha del sistema **/
    fun actualizarFechaHora(){
        fecha_hora = ObtenerFechaHoraSistema().obtener()
    }



    fun actualizarCantidadUnidadesDeServicio(it: String) {
        cantidad_unidades_de_servicio = it

        actualizarSubtotal()
        /*
        if (it.toInt() > 0){
            actualizarSubtotal()
        }
        */

        /*
        if (it.toInt() == null){
            cantidad_unidades_de_servicio = 0
            actualizarSubtotal()
        }
         */
    }



    fun actualizarDescripcionServicio(it: String){
        descripcion_servicio = it
    }



    fun actualizarValorUnitarioServicio(it: String){
        valor_unitario_servicio = it
        actualizarSubtotal()
    }



    fun actualizarSubtotal(){

        //var texto_regex = Regex("[a-zA-Z]+")
        var numero_regex = Regex("[0-9]+")

        if ((cantidad_unidades_de_servicio.isEmpty())
            or (!cantidad_unidades_de_servicio.matches(numero_regex))
            or (valor_unitario_servicio.isEmpty())
            or (!valor_unitario_servicio.matches(numero_regex))
        ){
            subtotal_servicio = OperacionesMetematicas()
                .calcularSubtotal(
                    cantidad = 0,
                    valor_unitario = 0
                )
        } else{
            subtotal_servicio = OperacionesMetematicas()
                .calcularSubtotal(
                    cantidad_unidades_de_servicio.toInt()
                    ,valor_unitario_servicio.toInt())
        }
    }



    fun crearServicioEntidad(): ServicioEntidad? {

        /** creacion de la entidad **/
        val mServicioEntidad: ServicioEntidad

        if((fecha_hora > "")
            and (cantidad_unidades_de_servicio.toInt() > 0)
            and (descripcion_servicio > "")
            and (valor_unitario_servicio.toInt() > 0)
            and (subtotal_servicio.toInt() > 0)
        ){
            mServicioEntidad = ServicioEntidad(
                fecha_hora_creacion_servicio = fecha_hora,
                cantidad_unidades_de_servicio = cantidad_unidades_de_servicio.toInt(),
                descripcion_servicio = descripcion_servicio,
                valor_unitario_servicio = valor_unitario_servicio.toInt(),
                subtotal_servicio = subtotal_servicio.toInt()
            )

            return mServicioEntidad
        }else{
            return null
        }

    }



    fun actualizarListaServiciosAgregados(it: ServicioEntidad?){

        _uiState.update { currentState ->
            currentState.lista_servicios_agregados.add(it)
            currentState.copy(
                lista_servicios_agregados = _uiState.value.lista_servicios_agregados
            )
        }
    }



    fun crearServicio(){
        try {
            var mServicioEntidad = crearServicioEntidad()
            actualizarListaServiciosAgregados(mServicioEntidad)
            actualizarTotalSumaServicios(mServicioEntidad)
        }catch (e: Exception){
            Log.d("TAG>", "< e.message >    : ${e.message}")
            Log.d("TAG>", "< e.stackTrace > : ${e.stackTrace}")
        }
    }



    fun validarCampos_Formulario_AgregarServicios(): Boolean {
        /** validacion de llenado de los campos llenados de la entidad */

        if ((fecha_hora.isNotEmpty())
            and (cantidad_unidades_de_servicio.isNotEmpty())
            and (descripcion_servicio.isNotEmpty())
            and (valor_unitario_servicio.isNotEmpty())
            and (subtotal_servicio > 0)
        ){
            Log.d("TAG>", "campos correctos")
            crearServicio()
            return true
        } else{
            Log.d("TAG>", "campos vacios en el formulario")
            return false
        }
    }



    fun eliminarServicio(indice: Int,it: ServicioEntidad) {
        _uiState.update { currentState ->
            //currentState.lista_servicios_agregados.remove(it)
            currentState.lista_servicios_agregados.removeAt(indice)
            currentState.copy(
                lista_servicios_agregados = _uiState.value.lista_servicios_agregados
            )
        }
    }


    fun crearPrestadorServicioEntity(): DatosPrestadorServicioEntity {

        val mDatosPrestadorServicioEntity = DatosPrestadorServicioEntity(
            identificacion_tributaria = "NIT: 12685008-1",
            nombre = "Taller Quiceno",
            ubicacion = "Cra 11 #25b-21 Pereira - Risaralda",
            telefono = "Tel/WhatsApp 323 328 3353",
            email = "tallerquiceno@gmail.com",
        )

        return mDatosPrestadorServicioEntity

    }


    fun crearReceptorServicioEntity(): DatosReceptorServicioEntity {

        val mDatosReceptorServicioEntity = DatosReceptorServicioEntity(
            identificacion = identificacion_cliente,
            nombre = nombre_cliente,
            vehiculo_marca = vehiculo_marca,
            vehiculo_modelo = vehiculo_modelo,
            vehiculo_matricula = vehiculo_matricula,
        )

        return mDatosReceptorServicioEntity
    }



    fun crearReporteEntity(): ReporteEntity {
        val mReporteEntity = ReporteEntity(
            fecha_hora_generacion_reporte = ObtenerFechaHoraSistema().obtener(),
            tipo_reporte = "CUENTA DE COBRO",
            total_suma_servicios = total_suma_servicios,
            mDatosPrestadorServicioEntity = crearPrestadorServicioEntity(),
            mDatosReceptorServicioEntity = crearReceptorServicioEntity(),
            lista_servicios_agregados = uiState.value.lista_servicios_agregados.toList(),
        )

        return mReporteEntity

    }



    fun generarPdf(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            //var pdf = GenerarPdf(miAppUiState?.lista_servicios_agregados.toList(),cctqViewModel,context)
            var pdf = GenerarPdf(mReporteEntity = crearReporteEntity(), context = context)
            pdf.generar()
        }
    }
}