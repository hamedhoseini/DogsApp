package com.mihahoni.dogsapp.ui.dogDetails

import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.databinding.FragmentDogBreedDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogBreedDetailFragment : BaseFragment<FragmentDogBreedDetailBinding>() {

    override fun viewLayoutId(): Int = R.layout.fragment_dog_breed_detail
    private val dogBreedDetailViewModel by viewModels<DogBreedDetailViewModel>()
    override fun observeViewModel() {
    }

    override fun initViews() {
        initActionBar(show = true, showBackBtn = true, title = getString(R.string.dog_breed_images))
        getViewDataBinding().viewModel = dogBreedDetailViewModel
        getViewDataBinding().lifecycleOwner = this
        getViewDataBinding().breedDetailComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DetailScreen(dogBreedDetailViewModel.breedImagesListState)
            }
        }
    }
}