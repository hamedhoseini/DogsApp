package com.mihahoni.dogsapp.ui.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PresentationSlideAdapter(
    fa: FragmentActivity,
    private val presentationContentList: List<PresentationViewItem>
) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = presentationContentList.size

    override fun createFragment(position: Int): Fragment {
        return PresentationContentFragment.newInstance(presentationContentList[position])
    }

}