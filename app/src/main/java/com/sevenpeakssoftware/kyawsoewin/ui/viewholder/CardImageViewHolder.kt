package com.sevenpeakssoftware.kyawsoewin.ui.viewholder

import com.sevenpeakssoftware.kyawsoewin.databinding.ListItemCarImageBinding
import com.sevenpeakssoftware.kyawsoewin.domain.model.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.extensions.showImage
import com.sevenpeakssoftware.kyawsoewin.ui.base.viewholder.BaseViewHolder

class CardImageViewHolder(
    private val view: ListItemCarImageBinding,
) : BaseViewHolder<CarItemVO>(view.root) {

    override fun bind(item: CarItemVO) {
        showImage(imageView = view.ivCar, url = item.image)
    }
}
