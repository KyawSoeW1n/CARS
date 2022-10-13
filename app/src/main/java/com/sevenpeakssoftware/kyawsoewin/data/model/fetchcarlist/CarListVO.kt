package com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponse

class CarListVO constructor(
    val carList: MutableList<CarItemVO>
) {
    data class Builder(
        val carList: MutableList<CarItemVO> = mutableListOf(),
    ) {

        fun carList(carListResponse: CarListResponse) = apply {
            carListResponse.content.map {
                CarItemVO(
                    id = it.id,
                    dateTime = it.dateTime,
                    image = it.image,
                    title = it.title,
                    ingress = it.ingress
                )
            }
        }

        fun build() = CarListVO(carList = carList)
    }
}