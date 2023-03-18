package com.mihahoni.dogsapp.ui.dogDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mihahoni.dogsapp.base.ObservableViewModel
import com.mihahoni.dogsapp.data.StateHandler
import com.mihahoni.dogsapp.data.repository.DogBreedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedDetailViewModel @Inject constructor(
    private val dogBreedRepository: DogBreedRepository,
    state: SavedStateHandle
) : ObservableViewModel() {

    init {
        loadData(state.get<String>("breedName"))
    }

    private val _breedImagesListState = mutableStateOf(
        DogBreedDetailViewItem("", emptyList())
    )
    val breedImagesListState by lazy { _breedImagesListState }

    private val _breedImagesFetchingState = MutableLiveData<StateHandler>(StateHandler.Loading)
    val breedImagesFetchingState: LiveData<StateHandler> by lazy { _breedImagesFetchingState }

    private fun loadData(breedName: String?) {
        breedName?.let {
            viewModelScope.launch {
                try {
                    val dogBreedImagesList =
                        dogBreedRepository.getBreedAllImages(breedName = breedName).message.take(20)

                    _breedImagesListState.value =
                        DogBreedDetailViewItem(breedName, dogBreedImagesList)

                    _breedImagesFetchingState.value = StateHandler.Success(dogBreedImagesList)

                } catch (exception: Exception) {
                    _breedImagesFetchingState.value = StateHandler.Failure(exception.message)
                }
            }
        }
    }

}