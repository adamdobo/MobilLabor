package com.example.mobillabor

import com.example.mobillabor.dto.CharacterResponse
import com.example.mobillabor.dto.QuoteResponse
import com.example.mobillabor.model.BreakingBadCharacter

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

val MOCK_DAO_LIST_RESPONSE = listOf(
    getMockBreakingBadCharacter(1),
    getMockBreakingBadCharacter(2),
    getMockBreakingBadCharacter(3),
    getMockBreakingBadCharacter(4),
    getMockBreakingBadCharacter(5)
)

private fun getMockBreakingBadCharacter(id: Int) = BreakingBadCharacter(
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

private fun getMockCharacterResponse(id: Int) = CharacterResponse(
    charId = id,
    name = "TEST CHARACTER",
    birthday = "1995-10-10",
    occupation = listOf("1", "2"),
    img = "",
    status = "Alive",
    nickname = "TEST",
    appearance = listOf(1, 2, 3, 4),
    portrayed = "TEST ACTOR"
)
