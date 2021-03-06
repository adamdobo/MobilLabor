package com.example.mobillabor.mapper

import com.example.mobillabor.dto.CharacterResponse
import com.example.mobillabor.model.BreakingBadCharacter
import com.example.mobillabor.view.model.BreakingBadCharacterDetails
import com.example.mobillabor.view.model.BreakingBadCharacterListItem

fun CharacterResponse.toBreakingBadCharacterListItem() = BreakingBadCharacterListItem(
    charId = charId,
    name = name,
    img = img
)

fun CharacterResponse.toBreakingBadCharacter() = BreakingBadCharacter(
    charId = charId,
    name = name,
    birthday = birthday,
    occupation = occupation,
    img = img,
    status = status,
    nickname = nickname,
    appearance = appearance,
    portrayedBy = portrayed
)

fun BreakingBadCharacter.toBreakingBadCharacterListItem() = BreakingBadCharacterListItem(
    charId = charId,
    name = name,
    img = img
)

fun BreakingBadCharacter.toBreakingBadCharacterDetails() = BreakingBadCharacterDetails(
    charId = charId,
    name = name,
    birthday = birthday,
    occupation = occupation,
    img = img,
    status = status,
    nickname = nickname,
    appearance = appearance,
    portrayedBy = portrayedBy
)