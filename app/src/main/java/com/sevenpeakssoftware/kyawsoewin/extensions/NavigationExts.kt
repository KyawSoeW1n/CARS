package com.sevenpeakssoftware.kyawsoewin.extensions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

fun View.doNavigation(action: Int, bundle: Bundle? = null) {
    Navigation.findNavController(this)
        .navigate(action, bundle)
}

fun Fragment.clearStackNavigationToDestination(action: Int, bundle: Bundle? = null) {
    this.findNavController().navigate(
        action,
        bundle,
        androidx.navigation.NavOptions.Builder()
            .setPopUpTo(action, true)
            .build()
    )
}

fun Fragment.goBackToPreviousFragment() = findNavController().navigateUp()