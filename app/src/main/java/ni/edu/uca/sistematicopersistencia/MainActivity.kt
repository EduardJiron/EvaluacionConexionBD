package ni.edu.uca.sistematicopersistencia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.data.database.entities.ProductoAdacterVh

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtnombre = findViewById<EditText>(R.id.txtNombre)
        val txtprecio = findViewById<EditText>(R.id.txtPrecio)
        val txtexistencia = findViewById<EditText>(R.id.txtExistencia)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnLimpiar= findViewById<Button>(R.id.btnlimpiar)


        val room= Room.databaseBuilder(this, BaseDatos::class.java, "Producto").allowMainThreadQueries().build()

        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)

        val dao= room.productoDao()
        recyclerView.adapter= ProductoAdacterVh( dao.obtRegistos())






        btnAgregar.setOnClickListener(){

            try {

                if(txtnombre.text.toString().isEmpty() || txtprecio.text.toString().isEmpty() || txtexistencia.text.toString().isEmpty()){
                    Toast.makeText(this, "Ingrese los datos", Toast.LENGTH_SHORT).show()
                }else{
                    dao.insertarReg(producto= EntityProducto(nombre = txtnombre.text.toString(), precio = txtprecio.text.toString().toDouble(), existencia = txtexistencia.text.toString().toInt()))
                    recyclerView.adapter= ProductoAdacterVh( dao.obtRegistos())
                }
            }
            catch (e: Exception){
                Toast.makeText(this, "Error al ingresar los datos", Toast.LENGTH_SHORT).show()
            }

        }

        btnLimpiar.setOnClickListener(){

            txtexistencia.setText("")
            txtprecio.setText("")
            txtnombre.setText("")

        }


    }
}