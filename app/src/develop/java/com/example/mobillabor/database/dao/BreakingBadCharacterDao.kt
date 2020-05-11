package com.example.mobillabor.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillabor.model.BreakingBadCharacter

@Dao
interface BreakingBadCharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): List<BreakingBadCharacter>

    @Query("SELECT * FROM characters WHERE charId = :charId")
    fun getCharacterById(charId: Int): BreakingBadCharacter

    @Insert
    fun insertAll(vararg characters: BreakingBadCharacter)

    @Query("DELETE FROM characters WHERE charId = :charId")
    fun removeCharacter(charId: Int)
}