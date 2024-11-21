package com.mogun.bblind.data.source.local

import androidx.room.TypeConverters
import com.mogun.bblind.util.DateUtil
import java.util.Date

class DateConverter {

    @TypeConverters
    fun toDate(timestamp: String?): Date? {
        return timestamp?.let { DateUtil.dbDateFormat.parse(it) }
    }

    @TypeConverters
    fun toTimestamp(date: Date?): String? {
        return date?.let { DateUtil.dbDateFormat.format(it) }
    }
}