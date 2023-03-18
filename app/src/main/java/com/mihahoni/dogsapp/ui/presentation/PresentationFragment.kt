package com.mihahoni.dogsapp.ui.presentation

import androidx.core.content.ContextCompat
import androidx.databinding.Observable
import androidx.databinding.ObservableInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.data.PresentationEntity
import com.mihahoni.dogsapp.databinding.FragmentPresentationBinding
import com.mihahoni.dogsapp.util.ZoomOutPageTransformer
import com.mihahoni.dogsapp.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PresentationFragment : BaseFragment<FragmentPresentationBinding>() {

    private val presentationViewModel by viewModels<PresentationViewModel>()
    override fun viewLayoutId(): Int = R.layout.fragment_presentation

    override fun observeViewModel() {
        observeEvent(presentationViewModel.openDogsList, ::goToDogsList)

        presentationViewModel.pageNumber.addOnPropertyChangedCallback(
            object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, pageNumber: Int) {
                    val currentPage = (sender as ObservableInt).get()
                    if (currentPage == 3) {
                    } else {
                        getViewDataBinding().introViewPager.currentItem =
                            (sender as ObservableInt).get()
                    }
                }
            })
    }

    private fun goToDogsList() {
        findNavController(this@PresentationFragment).navigate(PresentationFragmentDirections.actionPresentationFragmentToDogsListFragment())
    }

    override fun initViews() {
        getViewDataBinding().viewModel = presentationViewModel
        setupFragmentPager(
            listOf(
                PresentationEntity(
                    image = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.img_presentation_dog1
                    ),
                    getString(R.string.hi_humans),
                    getString(R.string.do_you_want_know_us_more)
                ),
                PresentationEntity(
                    image = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.img_presentation_dog2
                    ),
                    getString(R.string.breeds),
                    getString(R.string.get_to_know_different_breeds)
                ),
                PresentationEntity(
                    image = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.img_presentation_dog3
                    ),
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