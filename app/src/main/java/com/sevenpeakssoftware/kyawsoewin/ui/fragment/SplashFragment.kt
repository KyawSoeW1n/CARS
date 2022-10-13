package com.sevenpeakssoftware.kyawsoewin.ui.fragment

import android.view.LayoutInflater
import com.sevenpeakssoftware.kyawsoewin.R
import com.sevenpeakssoftware.kyawsoewin.databinding.FragmentSplashBinding
import com.sevenpeakssoftware.kyawsoewin.extensions.doNavigation
import com.sevenpeakssoftware.kyawsoewin.extensions.onAnimationListener
import com.sevenpeakssoftware.kyawsoewin.ui.base.fragment.BaseViewBindingFragment

class SplashFragment : BaseViewBindingFragment<FragmentSplashBinding>() {
    override fun bindView(inflater: LayoutInflater): FragmentSplashBinding =
        FragmentSplashBinding.inflate(inflater)

    override fun setUp() {
        super.setUp()

        binding.motionLayout.onAnimationListener {
            requireView().doNavigation(R.id.action_navigation_splash_to_avigation_car_list)
        }
    }
}