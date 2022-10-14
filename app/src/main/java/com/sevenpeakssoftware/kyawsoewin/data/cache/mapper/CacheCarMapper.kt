package com.sevenpeakssoftware.kyawsoewin.data.cache.mapper

import com.sevenpeakssoftware.kyawsoewin.data.cache.entity.CacheCar
import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarItemVO

class CacheCarMapper {
    fun mapFromResponse(carList: MutableList<CarItemVO>): MutableList<CacheCar> {
        val cacheCarList = mutableListOf<CacheCar>()
        carList.map {
            CarItemVO(
                id = it.id,
                dateTime = it.dateTime,
                ingress = it.ingress,
                image = it.image,
                title = it.title,
            )
        }

        return cacheCarList
    }
}