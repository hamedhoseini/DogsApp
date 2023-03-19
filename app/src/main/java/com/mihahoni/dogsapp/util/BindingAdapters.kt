package com.mihahoni.dogsapp.util

import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.*
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.data.StateHandler
import com.mihahoni.dogsapp.ui.dogsList.DogBreedViewItem
import com.mihahoni.dogsapp.ui.dogsList.DogBreedsListAdapter


@BindingAdapter("bind:onPageChangeListener")
fun ViewPager2.bindOnPageChangeListener(listener: ViewPager2.OnPageChangeCallback) {
    registerOnPageChangeCallback(listener)
}

@BindingAdapter("bind:currentItem")
fun bindCurrentItem(
    viewPager2: ViewPager2,
    pageNumber: Int
) {
    viewPager2.currentItem = pageNumber
}

@BindingAdapter("bind:currentPageBtnText")
fun bindCurrentPageBtnText(
    button: Button,
    pageNumber: Int
) {
    if (pageNumber == 2) {
        button.setText(R.string.lets_go)
    } else {
        button.setText(R.string.next)
    }
}

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