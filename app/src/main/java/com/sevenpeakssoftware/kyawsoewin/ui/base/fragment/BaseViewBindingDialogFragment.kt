package com.sevenpeakssoftware.kyawsoewin.ui.base.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingDialogFragment<VB : ViewBinding> : DialogFragment() {


    private var _binding: VB? = null

    val binding get() = _binding!!

    abstract fun bindView(inflater: LayoutInflater): VB

    var isTransparent = false

    var isCancel = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        _binding = bindView(inflater)
        setTransparent()
        setCancelable()
        dialog?.let {
            if (isTransparent) {
                it.window?.let { window ->
                    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    window.requestFeature(Window.FEATURE_NO_TITLE)
                }
            }

            it.setCancelable(isCancel)
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()

        observe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun setTransparent() {}
    open fun setCancelable() {}

    open fun setUp() {}
    open fun observe() {}
}