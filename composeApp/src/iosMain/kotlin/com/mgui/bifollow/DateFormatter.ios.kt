package com.mgui.bifollow

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.dateWithTimeIntervalSince1970

actual fun convertMillisToDate(millis: Long): String {
    val date = NSDate.dateWithTimeIntervalSince1970(millis / 1000.0)
    val formatter = NSDateFormatter()
    formatter.dateFormat = "dd/MM/yyyy"
    return formatter.stringFromDate(date)
}