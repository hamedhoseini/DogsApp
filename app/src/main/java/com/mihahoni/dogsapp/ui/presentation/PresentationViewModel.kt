package com.mihahoni.dogsapp.ui.presentation

import android.view.View
import androidx.databinding.ObservableInt
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.mihahoni.dogsapp.base.ObservableViewModel
import com.mihahoni.dogsapp.util.SingleLiveDataEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PresentationViewModel @Inject constructor(
) : ObservableViewModel() {

    private val _openDogsList by lazy { SingleLiveDataEvent<Boolean>() }
    val openDogsList: SingleLiveDataEvent<Boolean> by lazy { _openDogsList }

    val pageNumber = ObservableInt()

    val pageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            pageNumber.set(position)
        }
    }

    fun goToTheNext(view: View) {
        if (pageNumber.get() == 2) {
            _openDogsList.value = true
        } else {
            pageNumber.set(pageNumber.get() + 1)
        }
    }


}