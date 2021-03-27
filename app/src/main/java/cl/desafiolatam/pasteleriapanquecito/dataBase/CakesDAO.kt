package cl.desafiolatam.pasteleriapanquecito.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface CakesDAO {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakes(cakes: List<CakesEntity>)
    @Query("SELECT*FROM cakes")
    fun getCakes(): LiveData<List<CakesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakesDetails(details: CakesDetailsEntity)
    @Query("SELECT*FROM cakes_details")
    fun getCakesDetails(): LiveData<CakesDetailsEntity>
}