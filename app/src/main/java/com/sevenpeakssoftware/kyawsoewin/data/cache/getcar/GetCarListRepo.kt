package com.sevenpeakssoftware.kyawsoewin.data.cache.getcar

import com.sevenpeakssoftware.kyawsoewin.domain.model.fetchcarlist.CarItemVO

interface GetCarListRepo {
    fun getCarList(): MutableList<CarItemVO>
}