package com.sevenpeakssoftware.kyawsoewin.mapper

import com.kuriotetsuya.domain.model.fetchcarlist.CarListVO
import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponseData

class CarListMapper : ResponseMapper<CarListResponseData, CarListVO> {
    override fun mapFromResponse(data: CarListResponseData): CarListVO {
        return CarListVO.Builder()
            .carList(carListResponseData = data)
            .build()
    }
}