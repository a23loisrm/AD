package com.example.uf1_proyecto

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.uf1_proyecto.adaptador.Recordatorio
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class AgregarRecordatorio : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_agregar_recordatorio, container, false)
        val btnGuardarRecordatorio = view.findViewById<Button>(R.id.btnGuardarRecordatorio)
        val calendario = view.findViewById<CalendarView>(R.id.calendarioRecordatorios)
        val descripcion = view.findViewById<EditText>(R.id.txtDescripcionRecordatorio)
        val hora = view.findViewById<TimePicker>(R.id.horaRecordatorio)

        hora.setIs24HourView(true) //Cambiamos a formato de 24 horas
        //pillamos la fecha actual
        val fechaActual = Calendar.getInstance()
        //valor inicial de la fecha
        var fechaSeleccionada = Calendar.getInstance()

        calendario.setOnDateChangeListener { _, year, month, dayOfMonth ->
            fechaSeleccionada.set(year, month, dayOfMonth)
        }

        btnGuardarRecordatorio.setOnClickListener {

            val horaSeleccionada = hora.hour
            val minutosSeleccionados = hora.minute
            fechaSeleccionada.set(Calendar.HOUR_OF_DAY, horaSeleccionada)
            fechaSeleccionada.set(Calendar.MINUTE, minutosSeleccionados)

            val descripcion = descripcion.text.toString()


            //verificamos que la fecha es la correcta
            if (fechaSeleccionada.timeInMillis < fechaActual.timeInMillis) {
                Toast.makeText(context, "La fecha no puede ser anterior al día de hoy.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Evita seguir si la fecha es anterior
            }

            // Verifica si la fecha es hoy y la hora seleccionada es anterior a la hora actual
            if (fechaSeleccionada.get(Calendar.DAY_OF_YEAR) == fechaActual.get(Calendar.DAY_OF_YEAR)) {
                if (horaSeleccionada < fechaActual.get(Calendar.HOUR_OF_DAY) ||
                    (horaSeleccionada == fechaActual.get(Calendar.HOUR_OF_DAY) && minutosSeleccionados < fechaActual.get(Calendar.MINUTE))) {
                    Toast.makeText(context, "La hora seleccionada ya ha pasado.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener // No permite continuar si la hora ya pasó
                }
            }

            // Verifica si la descripción está vacía
            if (descripcion.isEmpty()) {
                Toast.makeText(context, "Por favor, ingrese una descripción.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // No sigue si no hay descripción
            }

            // Crea un nuevo recordatorio
            val timestamp = fechaSeleccionada.timeInMillis

            val nuevoRecordatorio = Recordatorio(descripcion, timestamp)
            RecordatorioManager.listaRecordatorios.add(nuevoRecordatorio)
            view.findNavController().navigate(R.id.action_agregarRecordatorio_to_recordatorios)


        }
        return view
    }

}