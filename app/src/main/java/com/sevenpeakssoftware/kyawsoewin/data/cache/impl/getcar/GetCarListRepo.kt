package com.sevenpeakssoftware.kyawsoewin.data.cache.impl.getcar

import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarItemVO

interface GetCarListRepo {
    fun getCarList() : MutableList<CarItemVO>
}