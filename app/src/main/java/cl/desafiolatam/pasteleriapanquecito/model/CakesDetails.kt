package cl.desafiolatam.pasteleriapanquecito.model

data class CakesDetails(
    val id: Int,
    val title: String,
    val previewDescription: String,
    val image: String,
    val shape: String,
    val size: String,
    val price: Int,
    val lastPrice: Int,
    val delivery: Int
)