package com.sevenpeakssoftware.kyawsoewin.network.response.getcar

data class CarListResponseData(
    val content: MutableList<Content>,
    val serverTime: Int,
    val status: String
)


