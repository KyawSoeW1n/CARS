package com.sevenpeakssoftware.kyawsoewin.data.cache.insertcar

import com.sevenpeakssoftware.kyawsoewin.domain.model.CarItemVO


interface InsertCarListRepo {
    fun insertCarList(carList: MutableList<CarItemVO>)
}