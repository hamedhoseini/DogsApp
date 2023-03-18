package com.mihahoni.dogsapp.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlin.reflect.KFunction0


fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
        liveData.observe(this, Observer { it?.let { t -> action(t) } })
    }

    fun <T> LifecycleOwner.observeEvent(liveData: SingleLiveDataEvent<T>, action: KFunction0<Unit>) {
        liveData.observe(this, Observer { it?.let { action() } })
    }