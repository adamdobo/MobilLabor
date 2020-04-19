package com.example.mobillabor.view.details

import com.example.mobillabor.database.model.BreakingBadCharacter
import com.example.mobillabor.network.dto.QuoteResponse

interface CharacterDetailsScreen {
    fun showQuote(quoteResponse: QuoteResponse?)
    fun showQuoteErrorPage(e: Exception)
    fun showErrorPage()
    fun showCharacterDetails(details: BreakingBadCharacter)
}