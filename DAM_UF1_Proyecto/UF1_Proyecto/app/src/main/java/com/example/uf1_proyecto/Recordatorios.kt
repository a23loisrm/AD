package com.example.uf1_proyecto

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.adaptador.CustomAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Recordatorios : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recordatorios, container, false)
        val btnRecordatorio = view.findViewById<FloatingActionButton>(R.id.btnAñadirRecordatorio)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerRecordatorios)
       //cambiamos el color de la imagen que desde el xml no deja
        val cambiarColor = view.findViewById<FloatingActionButton>(R.id.btnAñadirRecordatorio)
        cambiarColor.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
        // Configura el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = CustomAdapter(RecordatorioManager.listaRecordatorios)
        recyclerView.adapter = adapter

        btnRecordatorio.setOnClickListener {
            view.findNavController().navigate(R.id.action_recordatorios_to_agregarRecordatorio)
        }
        // Actualiza la lista cuando regresas a este fragmento
        adapter.notifyDataSetChanged()
        return view
    }

}