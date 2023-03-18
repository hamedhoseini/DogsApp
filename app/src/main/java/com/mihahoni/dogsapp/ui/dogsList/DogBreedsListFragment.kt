package com.mihahoni.dogsapp.ui.dogsList

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.databinding.FragmentDogBreedsListBinding

class DogBreedsListFragment : BaseFragment<FragmentDogBreedsListBinding>() {

    private var columnCount = 3

    override fun viewLayoutId(): Int = R.layout.fragment_dog_breeds_list

    override fun observeViewModel() {
    }

    override fun initViews() {
        val dogsListAdapter = DogBreedsListAdapter()
        with(getViewDataBinding().rvDogsList) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = dogsListAdapter
        }
        dogsListAdapter.submitItems(listOf("Mamad", "Husky", "Boldog","Husky4","Husky325","Husky3522","Husky111",))

    }

}