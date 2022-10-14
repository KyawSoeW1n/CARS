package com.sevenpeakssoftware.kyawsoewin.extensions

import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_YYYY_HH24_MM
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_YYYY_HH_MM
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_YYYY_HH_MM_A
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.MMM_DD_YYYY_HH_M_A
import java.text.SimpleDateFormat
import java.util.*

private val MMM_DD_YYYY_HH_M_A_PATTERN = SimpleDateFormat(MMM_DD_YYYY_HH_M_A, Locale.ENGLISH)
private val DD_MMMM_YYYY_HH_MM_A_PATTERN = SimpleDateFormat(DD_MMMM_YYYY_HH_MM_A, Locale.ENGLISH)
private val DD_MMMM_YYYY_HH_MM_PATTERN = SimpleDateFormat(DD_MMMM_YYYY_HH_MM, Locale.ENGLISH)
private val DD_MMMM_YYYY_HH24_MM_PATTERN = SimpleDateFormat(DD_MMMM_YYYY_HH24_MM, Locale.ENGLISH)

fun convertCarDate(timeString: String): String {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = DD_MMMM_YYYY_HH_MM_A_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted.toString()
    } catch (e: Exception) {
        ""
    }
}

fun convertCarDate24HourFormat(timeString: String): String {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = DD_MMMM_YYYY_HH24_MM_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted.toString()
    } catch (e: Exception) {
        ""
    }
}