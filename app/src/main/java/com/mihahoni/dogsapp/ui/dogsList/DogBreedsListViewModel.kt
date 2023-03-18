package com.mihahoni.dogsapp.ui.dogsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mihahoni.dogsapp.base.ObservableViewModel
import com.mihahoni.dogsapp.data.StateHandler
import com.mihahoni.dogsapp.data.repository.DogBreedRepository
import com.mihahoni.dogsapp.util.SingleLiveDataEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class DogBreedsListViewModel @Inject constructor(
    private val dogBreedRepository: DogBreedRepository
) : ObservableViewModel() {

    init {
        loadData()
    }

    private val _dogBreedsList = MutableLiveData<List<DogBreedViewItem>>(emptyList())
    val dogBreedsList: LiveData<List<DogBreedViewItem>> by lazy { _dogBreedsList }

    private val _breedsFetchingState = MutableLiveData<StateHandler>(StateHandler.Loading)
    val breedsFetchingState: LiveData<StateHandler> by lazy { _breedsFetchingState }

    private val _breedDetail = SingleLiveDataEvent<String>()
    val breedDetail: SingleLiveDataEvent<String> by lazy { _breedDetail }

    private fun loadData() {
        viewModelScope.launch {
            try {
                val dogBreedsList = dogBreedRepository.getAllDogBreeds()
                val breedsViewItemList = mutableListOf<DogBreedViewItem>()
                dogBreedsList.message.keys.forEach { breedName ->
                    breedsViewItemList.add(
                        DogBreedViewItem(
                            null,
                            breedName
                        ) { onBreedItemClicked(breedName) }
                    )
                }
                _breedsFetchingState.value = StateHandler.Success(dogBreedsList)

                _dogBreedsList.value = breedsViewItemList

                getBreedRandomImage(breedsViewItemList)
            } catch (exception: Exception) {
                _breedsFetchingState.value = StateHandler.Failure(exception.message)
            }

        }
    }

    private fun getBreedRandomImage(breedsViewItemList: MutableList<DogBreedViewItem>) {
        viewModelScope.launch {
            breedsViewItemList.forEachIndexed() { index, breedName ->
                val getRandomImageJob =
                    async { dogBreedRepository.getRandomImageByBreed(breedName.name) }
                breedsViewItemList[index].imageUrl = getRandomImageJob.await().message
                _dogBreedsList.value = breedsViewItemList
            }
        }
    }

    private fun onBreedItemClicked(breedName: String) {
        _breedDetail.value = breedName
    }

}