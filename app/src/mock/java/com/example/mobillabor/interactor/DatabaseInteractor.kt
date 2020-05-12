package com.example.mobillabor.interactor

import com.example.mobillabor.MOCK_CHARACTER_LIST_RESPONSE
import com.example.mobillabor.mapper.toBreakingBadCharacter
import com.example.mobillabor.model.BreakingBadCharacter
import javax.inject.Inject

class DatabaseInteractor @Inject constructor() {

    fun getAllCharacters(): List<BreakingBadCharacter> {
        return MOCK_CHARACTER_LIST_RESPONSE.map { it.toBreakingBadCharacter() }
    }

    fun saveCharacters(characters: List<BreakingBadCharacter>) {
        //MOCK METHOD
    }

    fun removeCharacter(characterId: Int) {
        //MOCK METHOD
    }

    fun getCharacterDetails(id: Int): BreakingBadCharacter? {
        return MOCK_CHARACTER_LIST_RESPONSE.firstOrNull { it.charId == id }?.toBreakingBadCharacter()
    }
}