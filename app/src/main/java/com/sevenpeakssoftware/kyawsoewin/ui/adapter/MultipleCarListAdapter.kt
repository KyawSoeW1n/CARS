package com.sevenpeakssoftware.kyawsoewin.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.kyawsoewin.databinding.ListItemCarBinding
import com.sevenpeakssoftware.kyawsoewin.databinding.ListItemCarImageBinding
import com.sevenpeakssoftware.kyawsoewin.domain.model.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.extensions.adapterViewBinding
import com.sevenpeakssoftware.kyawsoewin.extensions.diffCallBackWith
import com.sevenpeakssoftware.kyawsoewin.ui.base.adapter.BaseMultipleViewListAdapter
import com.sevenpeakssoftware.kyawsoewin.ui.viewholder.CarItemViewHolder
import com.sevenpeakssoftware.kyawsoewin.ui.viewholder.CardImageViewHolder

class MultipleCarListAdapter : BaseMultipleViewListAdapter<CarItemVO>(
    diffCallback = diffCallBackWith(areItemTheSame = { item1, item2 ->
        item1.id == item2.id
    }, areContentsTheSame = { item1, item2 ->
        item1 == item2
    })
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            1 -> {
                CarItemViewHolder(parent.adapterViewBinding(ListItemCarBinding::inflate))
            }

            else -> {
                CardImageViewHolder(parent.adapterViewBinding(ListItemCarImageBinding::inflate))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CardImageViewHolder) {
            holder.bind(getItem(position))
        } else if (holder is CarItemViewHolder) {
            holder.bind(getItem(position))
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).id) {
            1 -> 1
            else -> 2
        }
    }
}