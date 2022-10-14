package com.sevenpeakssoftware.kyawsoewin.network.response.getcar

data class CarListResponse(
    val content: MutableList<Content>,
    val serverTime: Int,
    val status: String
)


