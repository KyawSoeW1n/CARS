package com.sevenpeakssoftware.kyawsoewin.extensions

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import coil.transform.CircleCropTransformation
import timber.log.Timber

fun showLog(message: String) = Timber.v(message = message)

fun RecyclerView.removeAdapter() {
    this.apply {
        adapter = null
    }
}

fun <T : ViewBinding> ViewGroup.adapterViewBinding(factory: (LayoutInflater, ViewGroup, Boolean) -> T) =
    factory(LayoutInflater.from(context), this, false)

fun showImage(
    imageView: ImageView,
    url: Any,
    isCircle: Boolean = false,
    placeHolder: Drawable? = null,
) {
    imageView.load(url) {
        crossfade(true)
        allowHardware(false)
        placeholder(placeHolder)
        if (isCircle) transformations(CircleCropTransformation())
    }

}