package com.sevenpeakssoftware.kyawsoewin.ui.base.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<ItemType> protected constructor(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {


    abstract fun bind(item: ItemType)
}