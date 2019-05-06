package com.macrosoft.reminder.database

import android.util.Log
import androidx.room.TypeConverter
import java.sql.Time
import java.sql.Date

class DateTypeConverter {
    @TypeConverter
    fun toDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun toLong(value: Date?): Long? {
        return if (value == null) null else value.time
    }

    @TypeConverter
    fun toArrayListTime(value: String?): ArrayList<Time>? {
        if (value == null) {
            return null
        } else {
            val timeList = ArrayList<Time>()
            for (s in value.split(",")) {
                timeList.add(Time(s.toLong()))
            }
            return timeList
        }
    }

    @TypeConverter
    fun toArrayListString(value: ArrayList<Time>?): String? {
        if (value == null) {
            return null
        } else {
            return value.joinToString(separator = ",") {it.time.toString()}
        }
    }
}

