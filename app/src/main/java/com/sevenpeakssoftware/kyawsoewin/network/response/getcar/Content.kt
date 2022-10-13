package com.sevenpeakssoftware.kyawsoewin.network.response.getcar

import com.sevenpeakssoftware.kyawsoewin.network.response.CarContent

data class Content(
    val changed: Int,
    val content: MutableList<CarContent>,
    val created: Int,
    val dateTime: String,
    val id: Int,
    val image: String,
    val ingress: String,
    val title: String
)