package com.example.mobillabor.interactor

import com.example.mobillabor.database.dao.BreakingBadCharacterDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseInteractor @Inject constructor(
    private val dao: BreakingBadCharacterDao
) {

    suspend fun getAllCharacters() = coroutineScope {
        return@coroutineScope withContext(Dispatchers.IO) {
            try {
                dao.getAllCharacters()
            } catch (e: Exception) {
                mutableListOf()
            }
        }
    }

}