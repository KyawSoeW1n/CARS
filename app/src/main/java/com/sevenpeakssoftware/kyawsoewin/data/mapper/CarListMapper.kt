package com.sevenpeakssoftware.kyawsoewin.data.mapper

import com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist.CarListVO
import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponse

class CarListMapper {
    fun mapFromResponse(
        response: CarListResponse,
    ): CarListVO {
        return CarListVO.Builder()
            .carList(carListResponse = response)
            .build()
    }
}