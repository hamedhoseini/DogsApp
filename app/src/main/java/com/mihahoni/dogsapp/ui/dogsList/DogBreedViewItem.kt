package com.mihahoni.dogsapp.ui.dogsList

data class DogBreedViewItem(
    var imageUrl: String?,
    val name: String,
    val onItemClick: (String) -> Unit
) {
    fun onClick() {
        onItemClick(name)
    }
}

