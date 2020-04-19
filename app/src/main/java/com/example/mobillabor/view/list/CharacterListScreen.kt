package com.example.mobillabor.view.list

import com.example.mobillabor.database.model.BreakingBadCharacter

interface CharacterListScreen {
    fun showList(characters: List<BreakingBadCharacter>?)
    fun showErrorPage(exception: Exception)
}