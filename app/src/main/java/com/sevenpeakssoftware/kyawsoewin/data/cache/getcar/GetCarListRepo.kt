package com.sevenpeakssoftware.kyawsoewin.data.cache.getcar

import com.kuriotetsuya.domain.model.fetchcarlist.CarItemVO

interface GetCarListRepo {
    fun getCarList(): MutableList<CarItemVO>
}