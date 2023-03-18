package com.mihahoni.dogsapp.ui.presentation

import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.databinding.FragmentPresentationContentBinding

class PresentationContentFragment(private val presentationItem: PresentationViewItem) :
    BaseFragment<FragmentPresentationContentBinding>() {
    override fun viewLayoutId(): Int = R.layout.fragment_presentation_content

    companion object {
        fun newInstance(
            presentationEntity: PresentationViewItem
        ): PresentationContentFragment {
            return PresentationContentFragment(presentationEntity)
        }
    }

    override fun observeViewModel() {
    }

    override fun initViews() {
        getViewDataBinding().presentationItem = presentationItem
    }
}