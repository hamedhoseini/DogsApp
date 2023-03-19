package com.mihahoni.dogsapp.ui.presentation

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.mihahoni.dogsapp.R
import com.mihahoni.dogsapp.base.BaseFragment
import com.mihahoni.dogsapp.databinding.FragmentPresentationBinding
import com.mihahoni.dogsapp.util.ZoomOutPageTransformer
import com.mihahoni.dogsapp.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PresentationFragment : BaseFragment<FragmentPresentationBinding>() {

    private lateinit var presentationPages: List<PresentationViewItem>
    private val presentationViewModel by viewModels<PresentationViewModel>()
    override fun viewLayoutId(): Int = R.layout.fragment_presentation

    override fun observeViewModel() {
        observeEvent(presentationViewModel.openDogsList, ::goToDogsList)
    }

    private fun goToDogsList() {
        findNavController(this@PresentationFragment).navigate(PresentationFragmentDirections.actionPresentationFragmentToDogsListFragment())
    }

    override fun initViews() {
        initActionBar(false)
        getViewDataBinding().viewModel = presentationViewModel

        presentationPages = listOf(
            PresentationViewItem(
                image = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.img_presentation_dog1
                ),
                getString(R.string.hi_humans),
                getString(R.string.do_you_want_know_us_more)
            ),
            PresentationViewItem(
                image = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.img_presentation_dog2
                ),
                getString(R.string.breeds),
                getString(R.string.get_to_know_different_breeds)
            ),
            PresentationViewItem(
                image = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.img_presentation_dog3
                ),
                getString(R.string.breeds_info),
                getString(R.string.learn_differences_and_similarities)
            )
        )

        setupFragmentPager(presentationPages)
    }

    private fun setupFragmentPager(introContentList: List<PresentationViewItem>) {
        val pagerAdapter = PresentationSlideAdapter(requireActivity(), introContentList)
        getViewDataBinding().introViewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
            setPageTransformer(ZoomOutPageTransformer())
            adapter = pagerAdapter
        }
        getViewDataBinding().wormDotsIndicator.setViewPager2(getViewDataBinding().introViewPager)

    }



}