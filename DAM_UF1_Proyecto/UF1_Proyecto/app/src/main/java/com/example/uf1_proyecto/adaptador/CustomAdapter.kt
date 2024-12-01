package com.example.uf1_proyecto.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Recordatorio(
    val descripcion: String,
    val fechaHora: Long // Timestamp para almacenar fecha y hora
)


class CustomAdapter(private val recordatorios: MutableList<Recordatorio>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val descripcion: TextView = view.findViewById(R.id.textDescripcion)
        val fechaHora: TextView = view.findViewById(R.id.textFechaHora)

        fun bind(recordatorio: Recordatorio) {
            descripcion.text = recordatorio.descripcion
            fechaHora.text = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                .format(Date(recordatorio.fechaHora))
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Aquí debes inflar el layout del item, no el layout del fragmento completo
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_item_recycler_view, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(recordatorios[position])
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int = recordatorios.size

}
