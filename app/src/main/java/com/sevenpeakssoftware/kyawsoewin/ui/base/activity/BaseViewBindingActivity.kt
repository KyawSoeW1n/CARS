package com.sevenpeakssoftware.kyawsoewin.ui.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<VB : ViewBinding> : BaseActivity() {
    private var _binding: VB? = null

    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setUp()
        observe()
    }

    abstract fun getViewBinding(): VB

    private fun setTitle(title: String?) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    open fun setUp() {}

    open fun observe() {}

    override fun setTitle(@StringRes stringRes: Int) = setTitle(getString(stringRes))
}