package com.sevenpeakssoftware.kyawsoewin.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.kyawsoewin.ui.base.adapter.BaseListAdapter
import com.sevenpeakssoftware.kyawsoewin.ui.base.adapter.BaseMultipleViewListAdapter

inline fun <D, VH : RecyclerView.ViewHolder, reified T : BaseListAdapter<D, VH>> RecyclerView.setUpCustomAdapter(
    isLinear: Boolean = false,
    isVertical: Boolean = true,
    adapterName: T,
) {
    if (isLinear) {
        if (isVertical) {
            setLinearLayoutManager()
        } else {
            setLinearLayoutManager(orientation = LinearLayoutManager.HORIZONTAL)
        }
    }
    this.adapter = adapterName
}

inline fun <D, reified T : BaseMultipleViewListAdapter<D>> RecyclerView.setMultipleAdapter(
    isLinear: Boolean = false,
    isVertical: Boolean = true,
    adapterName: T,
) {
    if (isLinear) {
        if (isVertical) {
            setLinearLayoutManager()
        } else {
            setLinearLayoutManager(orientation = LinearLayoutManager.HORIZONTAL)
        }
    }
    this.adapter = adapterName
}

fun RecyclerView.setLinearLayoutManager(orientation: Int = RecyclerView.VERTICAL) {
    layoutManager = LinearLayoutManager(context, orientation, false)
}