package com.sevenpeakssoftware.kyawsoewin.data.cache.insertcar

import android.content.Context
import android.text.format.DateFormat
import com.sevenpeakssoftware.kyawsoewin.cache.dao.CarDao
import com.sevenpeakssoftware.kyawsoewin.cache.entity.CacheCar
import com.sevenpeakssoftware.kyawsoewin.domain.model.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.extensions.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class InsertCarListImpl @Inject constructor(
    private val carDao: CarDao,
    @ApplicationContext private val context: Context
) : InsertCarListRepo {
    override fun insertCarList(carList: MutableList<CarItemVO>) {
        carDao.insertTicketList(cacheTicketList = carList.map {
            CacheCar(
                id = it.id,
                image = it.image,
                ingress = it.ingress,
                dateTime = if (DateFormat.is24HourFormat(context)) {
                    if (isWithinCurrentYear(it.dateTime)) {
                        convertDDMMMMHHMM(it.dateTime)
                    } else {
                        convertDDMMMMYYYYHHMM(it.dateTime)
                    }
                } else {
                    if (isWithinCurrentYear(it.dateTime)) {
                        convertDDMMMMHHMMA(it.dateTime)
                    } else {
                        convertDDMMMMYYYYHHMMA(it.dateTime)
                    }
                },
                title = it.title
            )
        }.toMutableList())
    }
}