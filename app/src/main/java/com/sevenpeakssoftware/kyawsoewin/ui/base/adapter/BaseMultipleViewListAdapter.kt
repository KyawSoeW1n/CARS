package com.sevenpeakssoftware.kyawsoewin.ui.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


abstract class BaseMultipleViewListAdapter<ItemType> protected constructor(
    diffCallback: DiffUtil.ItemCallback<ItemType>
) : ListAdapter<ItemType, RecyclerView.ViewHolder>(diffCallback) {}