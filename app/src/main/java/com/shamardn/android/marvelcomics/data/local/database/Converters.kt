package com.shamardn.android.marvelcomics.data.local.database

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun dateToLong(date: Date): Long{
        return date.time
    }

    @TypeConverter
    fun longToDate(long: Long): Date{
        return Date(long)
    }
}