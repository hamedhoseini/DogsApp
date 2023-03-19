package com.mihahoni.dogsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.mihahoni.dogsapp.ui.MainActivity

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    private lateinit var mViewDataBinding: T
    abstract fun viewLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, viewLayoutId(), container, false)

        return mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    fun initActionBar(show: Boolean, showBackBtn: Boolean? = null, title: String? = null) {
        val actionBar = (requireActivity() as MainActivity).supportActionBar
        if (show) {
            actionBar?.show()
        } else {
            actionBar?.hide()
        }
        showBackBtn?.let {
            actionBar?.setHomeButtonEnabled(it)
            actionBar?.setDisplayHomeAsUpEnabled(it)
        }
        title?.let {
            actionBar?.title = it
        }
    }

    fun getViewDataBinding() = mViewDataBinding
    abstract fun observeViewModel()
    abstract fun initViews()
}