package com.kuriotetsuya.domain.remote.fetchcarlist

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponseData


interface FetchCarListRepo {
    suspend fun getCarList(): CarListResponseData
}