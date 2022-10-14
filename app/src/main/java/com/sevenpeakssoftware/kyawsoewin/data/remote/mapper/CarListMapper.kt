package com.sevenpeakssoftware.kyawsoewin.data.remote.mapper

import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarListVO
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