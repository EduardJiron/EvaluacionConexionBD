package ni.edu.uca.sistematicopersistencia.data.database.entities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.sistematicopersistencia.R

class personaAdacterVh(private val producto: List<EntityProducto>): RecyclerView.Adapter<personaAdacterVh.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): personaAdacterVh.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.itemproducto, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: personaAdacterVh.ViewHolder, position: Int) {
        holder.bindItems(producto[position])

    }

    override fun getItemCount(): Int {
        return producto.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(producto: EntityProducto){
            val textViewNombre = itemView.findViewById(R.id.tvNombre) as TextView
            val textViewPrecio = itemView.findViewById(R.id.tvprecio) as TextView
            val textViewExistencia = itemView.findViewById(R.id.tvexistencia) as TextView
            textViewNombre.text = producto.nombre
            textViewPrecio.text = producto.precio.toString()
            textViewExistencia.text = producto.existencia.toString()









        }
    }
}