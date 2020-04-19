package com.example.mobillabor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mobillabor.converters.IntListConverter
import com.example.mobillabor.converters.StringListConverter

@Entity(tableName = "characters")
data class BreakingBadCharacter(
    @PrimaryKey
    val charId: Int,
    val name: String,
    val birthday: String,
    @TypeConverters(StringListConverter::class)
    val occupation: List<String>,
    val img: String,
    val status: String,
    val nickname: String,
    @TypeConverters(IntListConverter::class)
    val appearance: List<Int>,
    val portrayedBy: String?
)