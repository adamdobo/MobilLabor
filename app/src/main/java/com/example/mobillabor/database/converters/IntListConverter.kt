package com.example.mobillabor.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IntListConverter(private val gson: Gson) {

    @TypeConverter
    fun fromList(ints: List<Int>): String {
        return gson.toJson(ints)
    }

    @TypeConverter
    fun fromString(string: String): List<Int> {
        val listType =  object: TypeToken<List<Int>>() {}.type

        return gson.fromJson(string, listType)
    }
}