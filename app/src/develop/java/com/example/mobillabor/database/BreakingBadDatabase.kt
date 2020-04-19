package com.example.mobillabor.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobillabor.converters.IntListConverter
import com.example.mobillabor.converters.StringListConverter
import com.example.mobillabor.database.dao.BreakingBadCharacterDao
import com.example.mobillabor.model.BreakingBadCharacter

@Database(entities = [BreakingBadCharacter::class], version = 1)
@TypeConverters(value = [IntListConverter::class, StringListConverter::class])
abstract class BreakingBadDatabase: RoomDatabase() {
    abstract fun breakingBadCharacterDao(): BreakingBadCharacterDao
}