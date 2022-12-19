package com.shamardn.android.marvelcomics.utils

import java.text.SimpleDateFormat
import java.util.*

fun convertStringToDate(dateString: String?): Date {
    return if (dateString.isNullOrEmpty()) {
        Date()
    } else {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
        formatter.parse(dateString) ?: Date()
    }
}
