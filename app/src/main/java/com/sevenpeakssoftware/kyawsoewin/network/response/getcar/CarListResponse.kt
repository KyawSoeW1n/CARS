package com.sevenpeakssoftware.kyawsoewin.network.response.getcar

import com.sevenpeakssoftware.kyawsoewin.network.response.getcar.Content

data class CarListResponse(
    val content: MutableList<Content>,
    val serverTime: Int,
    val status: String
)


