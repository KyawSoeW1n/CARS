package com.sevenpeakssoftware.kyawsoewin.extensions

import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_HH_MM_24
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_HH_MM_A_12
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_YYYY_HH_MM_24
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.DD_MMMM_YYYY_HH_MM_A_12
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.MMM_DD_YYYY_HH_M_A
import com.sevenpeakssoftware.kyawsoewin.core.DateConstants.YYYY
import java.text.SimpleDateFormat
import java.util.*

private val MMM_DD_YYYY_HH_M_A_PATTERN = SimpleDateFormat(MMM_DD_YYYY_HH_M_A, Locale.ENGLISH)
private val DD_MMMM_YYYY_HH_MM_A_12_PATTERN =
    SimpleDateFormat(DD_MMMM_YYYY_HH_MM_A_12, Locale.ENGLISH)
private val DD_MMMM_YYYY_HH_MM_24_PATTERN = SimpleDateFormat(DD_MMMM_YYYY_HH_MM_24, Locale.ENGLISH)
private val DD_MMMM_HH_MM_24_PATTERN = SimpleDateFormat(DD_MMMM_HH_MM_24, Locale.ENGLISH)
private val DD_MMMM_HH_MM_A_12_PATTERN = SimpleDateFormat(DD_MMMM_HH_MM_A_12, Locale.ENGLISH)
private val YYYY_PATTERN = SimpleDateFormat(YYYY, Locale.ENGLISH)
val currentYear = Calendar.getInstance().get(Calendar.YEAR)

fun isWithinCurrentYear(timeString: String): Boolean {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = YYYY_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted?.let {
            currentYear.toString() == it
        } ?: run {
            false
        }
    } catch (e: Exception) {
        false
    }
}

fun convertDDMMMMYYYYHHMMA(timeString: String): String {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = DD_MMMM_YYYY_HH_MM_A_12_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted.toString()
    } catch (e: Exception) {
        ""
    }
}

fun convertDDMMMMYYYYHHMM(timeString: String): String {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = DD_MMMM_YYYY_HH_MM_24_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted.toString()
    } catch (e: Exception) {
        ""
    }
}

fun convertDDMMMMHHMMA(timeString: String): String {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = DD_MMMM_HH_MM_A_12_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted.toString()
    } catch (e: Exception) {
        ""
    }
}

fun convertDDMMMMHHMM(timeString: String): String {
    return try {
        val parser = MMM_DD_YYYY_HH_M_A_PATTERN
        val simpleDateFormat = DD_MMMM_HH_MM_24_PATTERN
        val date = parser.parse(timeString)
        val formatted = date?.let { simpleDateFormat.format(it) }
        formatted.toString()
    } catch (e: Exception) {
        ""
    }
}