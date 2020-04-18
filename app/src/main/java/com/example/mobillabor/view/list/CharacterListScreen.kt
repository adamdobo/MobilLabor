package com.example.mobillabor.view.list

import com.example.mobillabor.network.dto.CharacterListResponse

interface CharacterListScreen {
    fun showList(characters: CharacterListResponse?)
    fun showErrorPage(exception: Exception)
}