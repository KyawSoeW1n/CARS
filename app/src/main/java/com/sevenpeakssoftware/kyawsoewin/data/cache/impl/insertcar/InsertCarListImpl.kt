package com.sevenpeakssoftware.kyawsoewin.data.cache.impl.insertcar

import android.content.Context
import android.text.format.DateFormat
import com.sevenpeakssoftware.kyawsoewin.data.cache.dao.CarDao
import com.sevenpeakssoftware.kyawsoewin.data.cache.entity.CacheCar
import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.extensions.convertCarDate
import com.sevenpeakssoftware.kyawsoewin.extensions.convertCarDate24HourFormat
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
                    convertCarDate24HourFormat(it.dateTime)
                } else {
                    convertCarDate(it.dateTime)
                },
                title = it.title
            )
        }.toMutableList())
    }
}