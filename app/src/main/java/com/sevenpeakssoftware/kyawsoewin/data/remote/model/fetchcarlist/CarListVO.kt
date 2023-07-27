package com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponse

class CarListVO constructor(
    val carList: MutableList<CarItemVO>
) {
    data class Builder(
        val carList: MutableList<CarItemVO> = mutableListOf(),
    ) {

        fun carList(carListResponse: CarListResponse) = apply {
            carList.addAll(carListResponse.content.map {
                CarItemVO(
                    id = it.id ?: 0,
                    dateTime = it.dateTime ?: "",
                    image = it.image ?: "",
                    title = it.title ?: "",
                    ingress = it.ingress ?: ""
                )
            })
        }

        fun build() = CarListVO(carList = carList)
    }
}