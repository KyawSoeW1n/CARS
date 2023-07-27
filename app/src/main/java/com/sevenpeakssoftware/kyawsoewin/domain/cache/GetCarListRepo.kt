package com.sevenpeakssoftware.kyawsoewin.domain.cache

import com.sevenpeakssoftware.kyawsoewin.cache.entity.CacheCar
import kotlinx.coroutines.flow.Flow

interface GetCarListRepo {
    suspend fun getCarList(): Flow<MutableList<CacheCar>>
}