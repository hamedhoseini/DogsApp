package com.mihahoni.dogsapp.ui.dogsList

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.databinding.FragmentDogBreedsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogBreedsListFragment : BaseFragment<FragmentDogBreedsListBinding>() {

    private lateinit var dogsListAdapter: DogBreedsListAdapter
    private var columnCount = 3

    private val dogBreedsListViewModel by viewModels<DogBreedsListViewModel>()
    override fun viewLayoutId(): Int = R.layout.fragment_dog_breeds_list

    override fun observeViewModel() {
    }

    override fun initViews() {
        getViewDataBinding().viewModel = dogBreedsListViewModel
        getViewDataBinding().lifecycleOwner = this

        dogsListAdapter = DogBreedsListAdapter()
        with(getViewDataBinding().rvDogsList) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = dogsListAdapter
        }
    }

}