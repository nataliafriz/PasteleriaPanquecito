package cl.desafiolatam.pasteleriapanquecito.model

import java.util.*

data class Cakes (
    val id: Int,
    val title: String,
    val previewDescription: String,
    val size: String,
    val price: Int,
    val image: String
        )