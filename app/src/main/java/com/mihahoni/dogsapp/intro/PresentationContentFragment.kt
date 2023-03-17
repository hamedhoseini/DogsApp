package com.mihahoni.dogsapp.intro

import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.data.PresentationEntity
import com.mihahoni.dogsapp.databinding.FragmentPresentationContentBinding

class PresentationContentFragment(private val presentationEntity: PresentationEntity) : BaseFragment<FragmentPresentationContentBinding>() {
    override fun viewLayoutId(): Int = R.layout.fragment_presentation_content

    companion object {
        fun newInstance(
            presentationEntity: PresentationEntity
        ): PresentationContentFragment {
            return PresentationContentFragment(presentationEntity)
        }
    }

    override fun observeViewModel() {
    }

    override fun initViews() {
        getViewDataBinding().imgViewIntroMain.setImageResource(presentationEntity.image)
        getViewDataBinding().textViewIntroTitle.text= presentationEntity.title
        getViewDataBinding().textViewIntroDescription.text= presentationEntity.description
    }
}