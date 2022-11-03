package com.sevenpeakssoftware.kyawsoewin.data.cache.insertcar

import com.kuriotetsuya.domain.model.fetchcarlist.CarItemVO

interface InsertCarListRepo {
    fun insertCarList(carList: MutableList<CarItemVO>)
}