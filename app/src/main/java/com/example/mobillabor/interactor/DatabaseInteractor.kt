package com.example.mobillabor.interactor

import android.util.Log
import com.example.mobillabor.database.dao.BreakingBadCharacterDao
import com.example.mobillabor.database.model.BreakingBadCharacter
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
                Log.d("CHARACTER DAO", "Getting characters from database...")
                dao.getAllCharacters()
            } catch (e: Exception) {
                mutableListOf<BreakingBadCharacter>()
            }
        }
    }

    suspend fun saveCharacters(characters: List<BreakingBadCharacter>) = coroutineScope {
        return@coroutineScope withContext(Dispatchers.IO) {
            Log.d("CHARACTER DAO", "Saving characters to database...")
            dao.insertAll(*characters.toTypedArray())
        }
    }

    suspend fun getCharacterDetails(id: Int): BreakingBadCharacter? = coroutineScope {
        return@coroutineScope withContext(Dispatchers.IO) {
            try {
                Log.d("CHARACTER DAO", "Getting character details from database...")
                dao.getCharacterById(id)
            } catch (e: Exception) {
                null
            }
        }
    }
}