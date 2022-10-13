package com.sevenpeakssoftware.kyawsoewin.ui.viewholder

import com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.databinding.ListItemCarBinding
import com.sevenpeakssoftware.kyawsoewin.extensions.showImage
import com.sevenpeakssoftware.kyawsoewin.ui.base.viewholder.BaseViewHolder

class CarItemViewHolder(
    private val view: ListItemCarBinding,
) : BaseViewHolder<CarItemVO>(view.root) {

    override fun bind(item: CarItemVO) {
        view.txtTitle.text = item.title
        view.txtDate.text = item.dateTime
        view.txtIngress.text = item.ingress
        showImage(imageView = view.ivCar, url = item.image)
    }
}
