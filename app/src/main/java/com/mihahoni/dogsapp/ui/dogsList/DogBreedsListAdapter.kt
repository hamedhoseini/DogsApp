package com.mihahoni.dogsapp.ui.dogsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mihahoni.dogsapp.databinding.LayoutDogBreedItemBinding

class DogBreedsListAdapter : RecyclerView.Adapter<DogBreedsListAdapter.ViewHolder>() {

    private lateinit var listener: BreedAdapterListener
    private var items: List<String?> = ArrayList()

    fun submitItems(data: List<String>) {
        items = data
        notifyDataSetChanged()
    }

    fun setOnBreedClickListener(onBreedItemListener: BreedAdapterListener) {
        listener = onBreedItemListener
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
        fun bind(sourceItem: String?) {
            binding.textViewBreedName.text = sourceItem
            itemView.setOnClickListener { listener.onDogBreedClicked(sourceItem) }
        }
    }

    interface BreedAdapterListener {
        fun onDogBreedClicked(source: String?)
    }
}