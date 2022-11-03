package com.sevenpeakssoftware.kyawsoewin.ui.adapter

import android.view.ViewGroup
import com.sevenpeakssoftware.kyawsoewin.databinding.ListItemCarBinding
import com.kuriotetsuya.domain.model.fetchcarlist.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.extensions.adapterViewBinding
import com.sevenpeakssoftware.kyawsoewin.extensions.diffCallBackWith
import com.sevenpeakssoftware.kyawsoewin.ui.base.adapter.BaseListAdapter
import com.sevenpeakssoftware.kyawsoewin.ui.viewholder.CarItemViewHolder

class CarListAdapter :
    BaseListAdapter<CarItemVO, CarItemViewHolder>(
        diffCallback = diffCallBackWith(areItemTheSame = { item1, item2 ->
            item1.id == item2.id
        }, areContentsTheSame = { item1, item2 ->
            item1 == item2
        })
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        return CarItemViewHolder(parent.adapterViewBinding(ListItemCarBinding::inflate))
    }
}