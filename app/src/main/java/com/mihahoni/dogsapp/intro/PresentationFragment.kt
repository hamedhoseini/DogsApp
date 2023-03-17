package com.mihahoni.dogsapp.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.data.PresentationEntity
import com.mihahoni.dogsapp.databinding.FragmentPresentationBinding
import com.mihahoni.dogsapp.util.ZoomOutPageTransformer

class PresentationFragment : BaseFragment<FragmentPresentationBinding>() {

    override fun viewLayoutId(): Int = R.layout.fragment_presentation

    override fun observeViewModel() {
//
    }

    override fun initViews() {
        setupFragmentPager(
            listOf(
                PresentationEntity(
                    image = R.drawable.img_presentation_dog,
                    getString(R.string.hi_humans),
                    getString(R.string.do_you_want_know_us_more)
                ),
                PresentationEntity(
                    image = R.drawable.img_presentation_dog,
                    getString(R.string.breeds),
                    getString(R.string.get_to_know_different_breeds)
                ),
                PresentationEntity(
                    image = R.drawable.img_presentation_dog,
                    getString(R.string.breeds_info),
                    getString(R.string.know_differences_and_similarities)
                )
            )
        )
    }

    private fun setupFragmentPager(introContentList: List<PresentationEntity>) {
        val pagerAdapter = ScreenSlidePagerAdapter(requireActivity(), introContentList)
        getViewDataBinding().introViewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
            setPageTransformer(ZoomOutPageTransformer())
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
//                    when (position) {
//                        0 -> {
//                            binding.buttonNext.text = getString(R.string.start)
//                            binding.textViewPrevious.visibility= View.VISIBLE
//                            binding.textViewSkip.visibility= View.GONE
//                        }
//                        1 -> {
//                            binding.buttonNext.text = getString(R.string.next_level)
//                            binding.textViewPrevious.visibility= View.VISIBLE
//                            binding.textViewSkip.visibility= View.VISIBLE
//                        }
//                        2 -> {
//                            binding.buttonNext.text = getString(R.string.next_level)
//                            binding.textViewPrevious.visibility= View.GONE
//                            binding.textViewSkip.visibility= View.VISIBLE
//                        }
//                        else -> {
//                            binding.buttonNext.text = getString(R.string.next_level)
//                        }
//                    }
                    super.onPageSelected(position)
                }
            })

        }
        getViewDataBinding().wormDotsIndicator.setViewPager2(getViewDataBinding().introViewPager)


    }

    private inner class ScreenSlidePagerAdapter(
        fa: FragmentActivity,
        val presentationContentList: List<PresentationEntity>
    ) : FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = presentationContentList.size

        override fun createFragment(position: Int): Fragment {
            return PresentationContentFragment.newInstance(presentationContentList[position])
        }

    }

}