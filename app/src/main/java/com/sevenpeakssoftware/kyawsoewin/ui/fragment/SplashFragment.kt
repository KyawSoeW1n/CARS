package com.sevenpeakssoftware.kyawsoewin.ui.fragment

import android.view.LayoutInflater
import com.sevenpeakssoftware.kyawsoewin.databinding.FragmentSplashBinding
import com.sevenpeakssoftware.kyawsoewin.ui.base.fragment.BaseViewBindingFragment

class SplashFragment : BaseViewBindingFragment<FragmentSplashBinding>() {
    override fun bindView(inflater: LayoutInflater): FragmentSplashBinding =
        FragmentSplashBinding.inflate(inflater)
}