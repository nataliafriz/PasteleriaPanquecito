package cl.desafiolatam.pasteleriapanquecito.api


import cl.desafiolatam.pasteleriapanquecito.model.Cakes
import cl.desafiolatam.pasteleriapanquecito.model.CakesDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET ( "cakes")
    suspend fun getCakesApi(): Response<List<Cakes>>
    @GET ( "cakeDetails/{pid}")
    suspend fun getCakesDetailsApi(@Path("pid") id: Int): Response<List<CakesDetails>>
}