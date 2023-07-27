package com.sevenpeakssoftware.kyawsoewin.mapper

interface ResponseMapper<E, T> {
    fun mapFromResponse(data: E): T
}