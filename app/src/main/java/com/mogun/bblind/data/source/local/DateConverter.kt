package com.mogun.bblind.data.source.local

import androidx.room.TypeConverter
import com.mogun.bblind.util.DateUtil
import java.util.Date

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: String?): Date? {
        return timestamp?.let { DateUtil.dbDateFormat.parse(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): String? {
        return date?.let { DateUtil.dbDateFormat.format(it) }
    }
}