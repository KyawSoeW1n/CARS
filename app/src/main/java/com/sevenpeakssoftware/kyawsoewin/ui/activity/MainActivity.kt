package com.sevenpeakssoftware.kyawsoewin.ui.activity

import com.sevenpeakssoftware.kyawsoewin.databinding.ActivityMainBinding
import com.sevenpeakssoftware.kyawsoewin.ui.base.activity.BaseViewBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}