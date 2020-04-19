package com.example.mobillabor

import com.example.mobillabor.dto.CharacterResponse
import com.example.mobillabor.dto.QuoteResponse

val MOCK_CHARACTER_LIST_RESPONSE = listOf(
    getMockCharacterResponse(1),
    getMockCharacterResponse(2),
    getMockCharacterResponse(3),
    getMockCharacterResponse(4),
    getMockCharacterResponse(5)
)

val MOCK_QUOTE_RESPONSE = QuoteResponse(
    quoteId = 1,
    author = "TEST CHARACTER",
    quote = "THIS IS A QUOTE"
)

private fun getMockCharacterResponse(id: Int) = CharacterResponse(
    charId = id,
    name = "TEST CHARACTER",
    birthday = "1995-10-10",
    occupation = listOf("1", "2"),
    img = "",
    status = "Alive",
    nickname = "TEST",
    appearance = listOf(1, 2, 3, 4),
    portrayedBy = "TEST ACTOR"
)