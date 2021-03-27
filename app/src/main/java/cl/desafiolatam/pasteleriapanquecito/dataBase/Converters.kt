package cl.desafiolatam.pasteleriapanquecito.dataBase

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun list2String(list: List<String>): String {
        return list.joinToString()
    }

    fun string2List(value: String): List<String> {
        return value.split(",").map {
            it.trim()
        }
    }
}