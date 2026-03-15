package com.mgui.bifollow

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

actual fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}