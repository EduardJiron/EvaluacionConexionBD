package ni.edu.uca.sistematicopersistencia.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto

@Dao
interface ProductoDao {
    @Query("SELECT * FROM TblProducto")
    fun obtRegistos():List<EntityProducto>

    @Query("SELECT * FROM TblProducto WHERE id= :id")
    fun obtRegistro(id:Int):Flow<EntityProducto>

    @Insert
    fun insertarReg(producto: EntityProducto)

    @Update
    fun actualizarReg(producto: EntityProducto)

    @Delete
    suspend fun eliminarReg(producto: EntityProducto)

}