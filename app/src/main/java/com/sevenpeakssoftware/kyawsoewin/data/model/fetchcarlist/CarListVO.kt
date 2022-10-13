package com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist

import com.sevenpeakssoftware.kyawsoewin.network.response.CarListResponse

class CarListVO constructor(
    val carList: MutableList<CarItemVO>
) {
    data class Builder(
        val carList: MutableList<CarItemVO> = mutableListOf(),
    ) {

        fun carList(carListResponse: CarListResponse) = apply {

        }

        fun build() = CarListVO(carList = carList)
    }
}