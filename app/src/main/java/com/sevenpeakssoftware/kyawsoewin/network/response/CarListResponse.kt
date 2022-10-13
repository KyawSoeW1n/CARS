package com.sevenpeakssoftware.kyawsoewin.network.response

data class CarListResponse(
    val content: MutableList<Content>,
    val serverTime: Int,
    val status: String
)

data class Content(
    val changed: Int,
    val content: MutableList<CarContent>,
    val created: Int,
    val dateTime: String,
    val id: Int,
    val image: String,
    val ingress: String,
//    val tags: MutableList<Any>,
    val title: String
)

data class CarContent(
    val description: String,
    val subject: String,
    val type: String
)