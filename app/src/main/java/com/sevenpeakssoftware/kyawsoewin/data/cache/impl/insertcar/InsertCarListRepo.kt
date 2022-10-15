package com.sevenpeakssoftware.kyawsoewin.data.cache.impl.insertcar

import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarItemVO

interface InsertCarListRepo {
    fun insertCarList(carList: MutableList<CarItemVO>)
}