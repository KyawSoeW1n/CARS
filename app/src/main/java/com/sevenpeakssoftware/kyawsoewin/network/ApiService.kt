package com.sevenpeakssoftware.kyawsoewin.network

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.CarListResponseData
import retrofit2.Call
import retrofit2.http.POST

interface ApiService {

    @POST("article/get_articles_list")
    fun getCarList(): Call<CarListResponseData>
}