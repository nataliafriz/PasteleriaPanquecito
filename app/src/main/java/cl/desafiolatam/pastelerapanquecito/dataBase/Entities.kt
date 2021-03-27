package cl.desafiolatam.pastelerapanquecito.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cakes")
data class CakesEntity (
    @PrimaryKey val id: Int,
                val title: String,
                val previewDescription: String,
                val size: String,
                val price: Int,
                val image: String
        )
@Entity(tableName = "cakes_details")
data class CakesDetailsEntity (
    @PrimaryKey val id: Int,
                val title: String,
                val previewDescription: String,
                val image: String,
                val shape: String,
                val size: String,
                val price: Int,
                val lastPrice: Int,
                val delivery: Int
        )