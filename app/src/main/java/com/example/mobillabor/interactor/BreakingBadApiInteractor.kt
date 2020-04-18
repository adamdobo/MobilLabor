package com.example.mobillabor.interactor

import com.example.mobillabor.network.BreakingBadApi
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.NetworkResponse
import com.example.mobillabor.network.dto.Success
import javax.inject.Inject

class BreakingBadApiInteractor @Inject constructor(
    private val api: BreakingBadApi
) {

    suspend fun getCharacters(): NetworkResponse {
        return try {
            val result = api.getCharacters()
            Success(result)
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getQuote(author: String): NetworkResponse {
        return try {
            val result = api.getRandomQuoteByCharacter(author)
            Success(result)
        } catch (e: Exception) {
            Error(e)
        }
    }

}