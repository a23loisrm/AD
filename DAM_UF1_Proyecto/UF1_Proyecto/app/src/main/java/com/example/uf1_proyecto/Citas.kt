package com.example.uf1_proyecto

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.uf1_proyecto.adaptador.Recordatorio


class Citas : Fragment() {

    private var horaSeleccionada: String? = null  // Variable para almacenar la hora seleccionada
    private var horaSeleccionadaNumerica: Int = -1  // Variable para la hora seleccionada en formato numérico
    private var minutosSeleccionados: Int = -1  // Variable para los minutos seleccionados

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_citas, container, false)
        val btnPedirCita = view.findViewById<Button>(R.id.btnPedirCita)
        val calendario = view.findViewById<CalendarView>(R.id.calendarioCitas)
        val btn1 = view.findViewById<Button>(R.id.btnHorario1)
        val btn2 = view.findViewById<Button>(R.id.btnHorario2)
        val btn3 = view.findViewById<Button>(R.id.btnHorario3)
        val btn4 = view.findViewById<Button>(R.id.btnHorario4)
        val btn5 = view.findViewById<Button>(R.id.btnHorario5)
        val btn6 = view.findViewById<Button>(R.id.btnHorario6)
        val btn7 = view.findViewById<Button>(R.id.btnHorario7)
        val btn8 = view.findViewById<Button>(R.id.btnHorario8)
        val btn9 = view.findViewById<Button>(R.id.btnHorario9)

        //valor de la fecha actual
        val fechaActual = Calendar.getInstance()

        //valor inicial de la fecha
        var fechaSeleccionada = Calendar.getInstance()

        calendario.setOnDateChangeListener { _, year, month, dayOfMonth ->
            fechaSeleccionada.set(year, month, dayOfMonth)
        }

        // valor del boton
        // Función para asignar la hora seleccionada y los minutos
        val seleccionarHorario = { button: Button, hora: String ->
            horaSeleccionada = hora
            val horaPartida = hora.split(":")
            horaSeleccionadaNumerica = horaPartida[0].toInt()
            minutosSeleccionados = horaPartida[1].toInt()
        }

        // Asignar los listeners a los botones
        btn1.setOnClickListener {
            seleccionarHorario(btn1, "9:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))

        }
        btn2.setOnClickListener { seleccionarHorario(btn2, "10:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
        }
        btn3.setOnClickListener { seleccionarHorario(btn3, "11:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
        }
        btn4.setOnClickListener { seleccionarHorario(btn4, "12:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))}
        btn5.setOnClickListener { seleccionarHorario(btn5, "13:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))}
        btn6.setOnClickListener { seleccionarHorario(btn6, "16:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))}
        btn7.setOnClickListener { seleccionarHorario(btn7, "17:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))}
        btn8.setOnClickListener { seleccionarHorario(btn8, "18:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))}
        btn9.setOnClickListener { seleccionarHorario(btn9, "19:00")
            btn1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn5.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn6.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn7.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn8.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.fondoCartas))
            btn9.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.violeta))}


        btnPedirCita.setOnClickListener {
            if (horaSeleccionada != null) {
                // Realiza la acción de pedir la cita, pasando la fecha y hora seleccionada
                // Aquí puedes hacer lo que desees, como navegar a otro fragmento o guardar la cita
                // Por ejemplo, agregarla al RecordatorioManager o pasarla como un argumento

                fechaSeleccionada.set(Calendar.HOUR_OF_DAY, horaSeleccionadaNumerica)
                fechaSeleccionada.set(Calendar.MINUTE, minutosSeleccionados)

                //verificamos que la fecha es la correcta
                if (fechaSeleccionada.timeInMillis < fechaActual.timeInMillis) {
                    Toast.makeText(context, "La fecha no puede ser anterior al día de hoy.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener // Evita seguir si la fecha es anterior
                }

                // Verifica si la fecha es hoy y la hora seleccionada es anterior a la hora actual
                if (fechaSeleccionada.get(Calendar.DAY_OF_YEAR) == fechaActual.get(Calendar.DAY_OF_YEAR)) { //Si la fecha selerccioanda es la misma que la de dia de hoy
                    if (horaSeleccionadaNumerica < fechaActual.get(Calendar.HOUR_OF_DAY) ||
                        (horaSeleccionadaNumerica == fechaActual.get(Calendar.HOUR_OF_DAY) && minutosSeleccionados < fechaActual.get(Calendar.MINUTE))) {
                        Toast.makeText(context, "La hora seleccionada ya ha pasado.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener // No permite continuar si la hora ya pasó
                    }
                }

                val fecha = fechaSeleccionada.timeInMillis
                val descripcionCita = "Cita a las $horaSeleccionada"

                // Crear el recordatorio o lo que sea necesario
                val nuevoRecordatorio = Recordatorio(descripcionCita, fecha)
                RecordatorioManager.listaRecordatorios.add(nuevoRecordatorio)

                view.findNavController().navigate(R.id.action_citas_to_citaConExito)

            } else {
                // Si no se ha seleccionado un horario
                Toast.makeText(context, "Por favor, seleccione un horario", Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }
}