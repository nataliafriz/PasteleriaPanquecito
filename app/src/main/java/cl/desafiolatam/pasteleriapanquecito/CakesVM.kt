package cl.desafiolatam.pasteleriapanquecito

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.pasteleriapanquecito.model.Cakes
import cl.desafiolatam.pasteleriapanquecito.model.CakesDetails
import cl.desafiolatam.pasteleriapanquecito.repository.Repository
import kotlinx.coroutines.launch

class CakesVM: ViewModel() {

    private val repository = Repository()

    fun cakeList(): LiveData<List<Cakes>> = repository.cakeList()

    fun getCake() {
        viewModelScope.launch {
            repository.getCake()
        }
    }

    fun getDetails(id: Int): LiveData<CakesDetails> = repository.getDetailFromDB(id)
    fun consumeDetail (id: Int) {
        viewModelScope.launch {
            repository.getDetail(id)
        }
    }

    private lateinit var selected: Cakes

    fun setSelected(cakes: Cakes) {
        selected = cakes
    }
    fun getSelected() = selected
}