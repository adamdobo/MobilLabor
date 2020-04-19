package com.example.mobillabor.network

import com.example.mobillabor.dto.CharacterResponse
import com.example.mobillabor.dto.QuoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingBadApi {

    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>

    @GET("quotes/random")
    suspend fun getRandomQuoteByCharacter(
        @Query("author") author: String
    ): QuoteResponse

}
