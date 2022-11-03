package com.sevenpeakssoftware.kyawsoewin.data.remote.fetchcarlist

import com.kuriotetsuya.domain.remote.fetchcarlist.FetchCarListRepo
import com.sevenpeakssoftware.kyawsoewin.network.ApiService
import com.sevenpeakssoftware.kyawsoewin.network.executeOrThrow
import javax.inject.Inject


class FetchCarImpl @Inject constructor(private val apiService: ApiService) :
    FetchCarListRepo {
    override suspend fun getCarList() = apiService.getCarList().executeOrThrow()
}