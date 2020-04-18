package com.example.mobillabor.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverter(private val gson: Gson) {
    @TypeConverter
    fun fromList(strings: List<String>): String {
        return gson.toJson(strings)
    }

    @TypeConverter
    fun fromString(string: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type

        return gson.fromJson(string, listType)
    }
}