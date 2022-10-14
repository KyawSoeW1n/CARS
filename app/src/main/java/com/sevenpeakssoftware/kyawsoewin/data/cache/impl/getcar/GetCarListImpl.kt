package com.sevenpeakssoftware.kyawsoewin.data.cache.impl.getcar

import com.sevenpeakssoftware.kyawsoewin.data.cache.dao.CarDao
import com.sevenpeakssoftware.kyawsoewin.data.cache.entity.CacheCar
import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarItemVO
import javax.inject.Inject

class GetCarListImpl @Inject constructor(private val carDao: CarDao) : GetCarListRepo {
    override fun getCarList(): MutableList<CarItemVO> {
        return carDao.getTicketList().map {
            CarItemVO(
                id = it.id,
                image = it.image,
                ingress = it.ingress,
                dateTime = it.dateTime,
                title = it.title
            )
        }.toMutableList()
    }
}