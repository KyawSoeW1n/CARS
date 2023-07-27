package com.kuriotetsuya.domain.model.fetchcarlist

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponseData

class CarListVO constructor(
    val carList: MutableList<CarItemVO>
) {
    data class Builder(
        val carList: MutableList<CarItemVO> = mutableListOf(),
    ) {

        fun carList(carListResponseData: CarListResponseData) = apply {
            carList.addAll(carListResponseData.content.map {
                CarItemVO(
                    id = it.id,
                    dateTime = it.dateTime,
                    image = it.image,
                    title = it.title,
                    ingress = it.ingress
                )
            })
        }

        fun build() = CarListVO(carList = carList)
    }
}