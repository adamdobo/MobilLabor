package com.example.mobillabor.view.details

import com.example.mobillabor.network.dto.QuoteResponse

interface CharacterDetailsScreen {
    fun showQuote(quoteResponse: QuoteResponse?)
    fun showErrorPage(exception: Exception)
}