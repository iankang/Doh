package com.example.doh.db

import androidx.room.TypeConverter
import java.util.*

class Converters {

    // Date Converter
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
}