package com.example.mobillabor.interactor

import com.example.mobillabor.dto.CharacterListResponse
import com.example.mobillabor.dto.Error
import com.example.mobillabor.dto.Success
import com.example.mobillabor.network.BreakingBadApi
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
                if(result.isNotEmpty()) {
                    Success(result[0])
                } else {
                    Error(Exception("No quote returned"))
                }
            } catch (e: Exception) {
                Error(e)
            }
        }
    }

}