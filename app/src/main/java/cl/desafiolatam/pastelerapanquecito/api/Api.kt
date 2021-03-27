package cl.desafiolatam.pastelerapanquecito.api

import cl.desafiolatam.pastelerapanquecito.model.Cakes
import cl.desafiolatam.pastelerapanquecito.model.CakesDetails
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET ( "cakes")
    suspend fun getCakesApi(): Response<List<Cakes>>
    @GET ( "cakeDetails")
    suspend fun getcakesDetailsApi(): Response<List<CakesDetails>>
}