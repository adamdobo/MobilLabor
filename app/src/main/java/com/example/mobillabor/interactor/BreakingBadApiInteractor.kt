package com.example.mobillabor.interactor

import com.example.mobillabor.network.BreakingBadApi
import com.example.mobillabor.network.dto.CharacterListResponse
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BreakingBadApiInteractor @Inject constructor(
    private val api: BreakingBadApi
) {

    suspend fun getCharacters() =
        coroutineScope {
            return@coroutineScope withContext(Dispatchers.IO) {
                try {
                    val result = api.getCharacters()
                    Success(CharacterListResponse(result))
                } catch (e: Exception) {
                    Error(e)
                }
            }
        }

    suspend fun getQuote(author: String) = coroutineScope {
        return@coroutineScope withContext(Dispatchers.IO) {
            try {
                val result = api.getRandomQuoteByCharacter(author)
                Success(result)
            } catch (e: Exception) {
                Error(e)
            }
        }
    }

}