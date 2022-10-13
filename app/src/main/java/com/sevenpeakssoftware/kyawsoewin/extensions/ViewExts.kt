package com.sevenpeakssoftware.kyawsoewin.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import timber.log.Timber

fun showLog(message: String) = Timber.v(message = message)

fun <T : ViewBinding> ViewGroup.adapterViewBinding(factory: (LayoutInflater, ViewGroup, Boolean) -> T) =
    factory(LayoutInflater.from(context), this, false)
