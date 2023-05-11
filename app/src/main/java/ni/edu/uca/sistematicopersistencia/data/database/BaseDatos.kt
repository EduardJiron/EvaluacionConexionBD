package ni.edu.uca.sistematicopersistencia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.edu.uca.sistematicopersistencia.data.database.dao.ProductoDao
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto

@Database(entities = [EntityProducto::class], version =1, exportSchema = false )
abstract class BaseDatos: RoomDatabase(){
    abstract fun productoDao(): ProductoDao


}