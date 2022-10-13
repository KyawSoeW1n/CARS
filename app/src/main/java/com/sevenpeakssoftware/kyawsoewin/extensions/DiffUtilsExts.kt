package com.sevenpeakssoftware.kyawsoewin.extensions

import androidx.recyclerview.widget.DiffUtil

inline fun <T : Any> diffCallBackWith(
    crossinline areItemTheSame: ((@ParameterName("oldItem") T, @ParameterName("newItem") T) -> Boolean),
    crossinline areContentsTheSame: ((@ParameterName("oldItem") T, @ParameterName("newItem") T) -> Boolean)
): DiffUtil.ItemCallback<T> {
    return object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return areItemTheSame.invoke(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return areContentsTheSame.invoke(oldItem, newItem)
        }
    }
}