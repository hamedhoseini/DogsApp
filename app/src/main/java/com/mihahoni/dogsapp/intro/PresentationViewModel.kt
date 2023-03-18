package com.mihahoni.dogsapp.intro

import android.util.Log
import android.view.View
import androidx.databinding.ObservableInt
import com.mihahoni.dogsapp.base.ObservableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PresentationViewModel @Inject constructor(
): ObservableViewModel() {

    val pageNumber = ObservableInt()


    fun goToTheNext(view:View){
        pageNumber.set(pageNumber.get()+1)
    }


}