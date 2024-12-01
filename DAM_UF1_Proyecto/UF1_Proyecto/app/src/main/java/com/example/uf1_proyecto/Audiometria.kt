package com.example.uf1_proyecto

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController

class Audiometria : Fragment() {

    private lateinit var imageViewDerecho: ImageView
    private lateinit var imageViewIzquierdo: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audiometria, container, false)

        imageViewDerecho = view.findViewById(R.id.imagenOidoDerecho)
        imageViewIzquierdo = view.findViewById(R.id.imagenOidoIzquierdo)

        // Recuperamos los datos pasados del fragmento de audiometrias
        val imagenD = arguments?.getInt("imagenDerecho")
        val imagenI = arguments?.getInt("imagenIzquierdo")

        // Insertamos las imágenes en los ImageView correspondientes
        imagenD?.let { imageViewDerecho.setImageResource(it) }
        imagenI?.let { imageViewIzquierdo.setImageResource(it) }

        return view
    }


}
