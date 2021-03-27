package cl.desafiolatam.pasteleriapanquecito.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import cl.desafiolatam.pasteleriapanquecito.api.RetrofitClient
import cl.desafiolatam.pasteleriapanquecito.dataBase.CakesApplication
import cl.desafiolatam.pasteleriapanquecito.dataBase.CakesDetailsEntity
import cl.desafiolatam.pasteleriapanquecito.dataBase.CakesEntity
import cl.desafiolatam.pasteleriapanquecito.model.Cakes
import cl.desafiolatam.pasteleriapanquecito.model.CakesDetails

class Repository {

  private val cakesDataBase = CakesApplication.dataBase!!.cakesDao()

  fun cakeList(): LiveData<List<Cakes>> = Transformations.map(cakesDataBase.getCakes()) {
    it.map { entity ->
      db2api(entity)
    }
  }

  fun getDetailFromDB(pid: Int): LiveData<CakesDetails> = Transformations.map(cakesDataBase.getCakesDetails(pid)) {
    it?.let { detailEntity ->
      db2api(detailEntity)
    }
  }

  suspend fun getCake() {
    val response = RetrofitClient.retrofitInstance().getCakesApi()

    response.let {
      when(it.isSuccessful) {
        true -> {
          response.body()?.let { cakeList ->
            val map = cakeList.map { cake ->
              api2db(cake)
            }
            cakesDataBase.insertCakes(map)
          }
        }
        false -> {
          Log.d("Repo", "error en Repo")
        }
      }
    }
  }

  suspend fun getDetail(id: Int) {
    val response = RetrofitClient.retrofitInstance().getCakesDetailsApi(id)

    if (response.isSuccessful) {
      response.body()?.let { details ->
      // cakesDataBase.insertCakesDetails(api2db(details))
      }
    } else {
    }
  }

}



fun api2db(cakes: Cakes): CakesEntity {
  return CakesEntity(cakes.id, cakes.title, cakes.previewDescription, cakes.image,cakes.price,cakes.size)
}

fun db2api(cakesEntity: CakesEntity): Cakes {
  return Cakes(cakesEntity.id, cakesEntity.title, cakesEntity.previewDescription, cakesEntity.image,cakesEntity.price,cakesEntity.size)
}

private fun api2db(detail: CakesDetails): CakesDetailsEntity {
  return CakesDetailsEntity(detail.id, detail.title, detail.previewDescription, detail.image, detail.shape, detail.size, detail.lastPrice,detail.price,detail.delivery)
}

fun db2api(detailEntity: CakesDetailsEntity): CakesDetails{
  return CakesDetails(detailEntity.id, detailEntity.title, detailEntity.previewDescription, detailEntity.image, detailEntity.shape, detailEntity.size, detailEntity.lastPrice,detailEntity.price,detailEntity.delivery)

  }







