package com.sevenpeakssoftware.kyawsoewin.domain.remote.fetchcarlist

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponse


interface FetchCarListRepo {
    suspend fun getCarList(): CarListResponse
}