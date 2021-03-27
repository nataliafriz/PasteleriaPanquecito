package cl.desafiolatam.pasteleriapanquecito

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.pastelerapanquecito.databinding.CakesItemBinding
import cl.desafiolatam.pasteleriapanquecito.model.Cakes


class CakesAdapter: RecyclerView.Adapter<CakesVH>() {

    private var cakesList = listOf<Cakes>()
    private var selectedItem = MutableLiveData<Cakes>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesVH {
        val binding = CakesItemBinding.inflate(LayoutInflater.from(parent.context))
        return CakesVH(binding)
    }

    override fun onBindViewHolder(holder: CakesVH, position: Int) {
        val cake = cakesList[position]
        holder.bind(cake)
        holder.itemView.setOnClickListener {
            selectedItem.value = cake
        }
    }

    override fun getItemCount() = cakesList.size

    fun selectedItem(): LiveData<Cakes> = selectedItem
    fun update (mCakeList: List<Cakes>) {
        cakesList = mCakeList
        notifyDataSetChanged()
    }


}

class CakesVH(val binding: CakesItemBinding): RecyclerView.ViewHolder(binding.root)  {
    fun bind(cake: Cakes) {

        binding.tvCakeTitle.text = cake.title
        binding.tvPriceCake.text = "$".plus(cake.price.toString())
        binding.tvSize.text = cake.size

    }

}


