package com.sevenpeakssoftware.kyawsoewin.ui.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null

    val binding get() = _binding!!

    abstract fun bindView(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        _binding = bindView(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        observe()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    open fun setUp() {}

    open fun observe() {}
}