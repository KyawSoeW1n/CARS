package com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist

data class CarItemVO(
    val id: Int,
    val dateTime: String,
    val title: String,
    val contentList: MutableList<ContentItemVO>
)