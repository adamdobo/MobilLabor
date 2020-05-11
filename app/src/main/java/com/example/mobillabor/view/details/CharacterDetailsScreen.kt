package com.example.mobillabor.view.details

import com.example.mobillabor.dto.QuoteResponse
import com.example.mobillabor.model.BreakingBadCharacter

interface CharacterDetailsScreen {
    fun showQuote(quoteResponse: QuoteResponse?)
    fun showQuoteErrorPage(e: Exception)
    fun showErrorPage()
    fun showCharacterDetails(details: BreakingBadCharacter)
}