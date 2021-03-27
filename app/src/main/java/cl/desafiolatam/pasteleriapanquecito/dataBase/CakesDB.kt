package cl.desafiolatam.pasteleriapanquecito.dataBase

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CakesEntity::class, CakesDetailsEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class CakesDataBase: RoomDatabase() {
    abstract fun cakesDao(): CakesDAO
}

class CakesApplication: Application() {
    companion object {
        var dataBase: CakesDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room
                   .databaseBuilder(this,CakesDataBase::class.java,"cakes_database")
                   .build()
    }
}