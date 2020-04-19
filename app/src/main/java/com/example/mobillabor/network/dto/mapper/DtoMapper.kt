package com.example.mobillabor.network.dto.mapper

import com.example.mobillabor.database.model.BreakingBadCharacter
import com.example.mobillabor.network.dto.CharacterResponse

fun CharacterResponse.toBreakingBadCharacter() = BreakingBadCharacter(
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