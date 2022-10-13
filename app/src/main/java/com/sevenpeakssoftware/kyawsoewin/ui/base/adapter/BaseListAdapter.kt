package com.sevenpeakssoftware.kyawsoewin.ui.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sevenpeakssoftware.kyawsoewin.ui.base.viewholder.BaseViewHolder

abstract class BaseListAdapter<ItemType, VH : BaseViewHolder<ItemType>> protected constructor(
    diffCallback: DiffUtil.ItemCallback<ItemType>
) :
    ListAdapter<ItemType, VH>(diffCallback) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

}