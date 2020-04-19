package com.example.mobillabor.interactor

import com.example.mobillabor.MOCK_CHARACTER_LIST_RESPONSE
import com.example.mobillabor.MOCK_QUOTE_RESPONSE
import com.example.mobillabor.dto.CharacterListResponse
import com.example.mobillabor.dto.NetworkResponse
import com.example.mobillabor.dto.QuoteResponse
import com.example.mobillabor.dto.Success
import javax.inject.Inject

class BreakingBadApiInteractor @Inject constructor() {

    fun getCharacters(): NetworkResponse<CharacterListResponse> =
        Success(CharacterListResponse(MOCK_CHARACTER_LIST_RESPONSE))

    fun getQuote(author: String): NetworkResponse<QuoteResponse> =
        Success(MOCK_QUOTE_RESPONSE)

}