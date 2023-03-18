package com.mihahoni.dogsapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.data.StateHandler
import com.mihahoni.dogsapp.ui.dogsList.DogBreedViewItem
import com.mihahoni.dogsapp.ui.dogsList.DogBreedsListAdapter

@BindingAdapter("bind:itemViewModels")
fun bindItemViewModels(
    recyclerView: RecyclerView,
    itemViewModels: List<DogBreedViewItem>?
) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): DogBreedsListAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is DogBreedsListAdapter) {
        recyclerView.adapter as DogBreedsListAdapter
    } else {
        val recyclerAdapter = DogBreedsListAdapter()
        recyclerView.adapter = recyclerAdapter
        recyclerAdapter
    }
}

@BindingAdapter("bind:imageUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(this.context).load(url).placeholder(R.drawable.img_dog_avatar).into(this);
    }
}

@BindingAdapter(value = ["bind:loadingVisibility"])
fun loadingVisibility(view: View, stateHandler: StateHandler) {
    view.visibility = if (stateHandler is StateHandler.Loading) View.VISIBLE else View.GONE
}