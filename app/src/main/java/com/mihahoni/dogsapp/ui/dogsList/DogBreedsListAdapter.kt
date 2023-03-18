package com.mihahoni.dogsapp.ui.dogsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mihahoni.dogsapp.databinding.LayoutDogBreedItemBinding

class DogBreedsListAdapter : RecyclerView.Adapter<DogBreedsListAdapter.ViewHolder>() {

    private var items: List<DogBreedViewItem> = ArrayList()

    fun updateItems(data: List<DogBreedViewItem>?) {
        items = data ?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutDogBreedItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        private val binding: LayoutDogBreedItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(breedViewItem: DogBreedViewItem) {
            binding.breedViewItem=breedViewItem
        }
    }
}