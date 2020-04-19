package com.example.mobillabor.view.list

import com.example.mobillabor.view.model.BreakingBadCharacterListItem

interface CharacterListScreen {
    fun showList(characters: List<BreakingBadCharacterListItem>?)
    fun showErrorPage(exception: Exception)
}