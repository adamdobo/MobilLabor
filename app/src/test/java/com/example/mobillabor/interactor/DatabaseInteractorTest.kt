package com.example.mobillabor.interactor

import android.util.Log
import com.example.mobillabor.MOCK_DAO_LIST_RESPONSE
import com.example.mobillabor.database.dao.BreakingBadCharacterDao
import io.mockk.*
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DatabaseInteractorTest {

    private lateinit var dao: BreakingBadCharacterDao
    private lateinit var interactor: DatabaseInteractor

    @Before
    fun setup() {
        dao = mockk()
        interactor = DatabaseInteractor(dao)
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0
    }

    @Test
    fun getAllCharacters() = runBlocking {
        every { dao.getAllCharacters() } returns MOCK_DAO_LIST_RESPONSE

        val response = interactor.getAllCharacters()

        verify { dao.getAllCharacters() }

        assertEquals(MOCK_DAO_LIST_RESPONSE.size, response.size)
    }

    @Test
    fun getAllCharactersWithException() = runBlocking {
        every { dao.getAllCharacters() } throws Exception()

        val response = interactor.getAllCharacters()

        verify { dao.getAllCharacters() }

        assertTrue(response.isEmpty())
    }

    @Test
    fun removeCharacter() = runBlocking {
        every { dao.removeCharacter(any()) } just Runs

        interactor.removeCharacter(1)

        verify { dao.removeCharacter(1) }
    }

    @Test
    fun removeCharacterWithException() = runBlocking {
        every { dao.removeCharacter(any()) } throws Exception()

        val response = interactor.removeCharacter(1)

        verify { dao.removeCharacter(1) }

        assertTrue(response == null)
    }

    @Test
    fun getCharacterDetails() = runBlocking {
        every { dao.getCharacterById(1) } returns MOCK_DAO_LIST_RESPONSE[0]

        val response = interactor.getCharacterDetails(1)

        verify { dao.getCharacterById(1) }

        assertTrue(response != null)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].charId, response?.charId)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].name, response?.name)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].nickname, response?.nickname)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].occupation, response?.occupation)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].portrayedBy, response?.portrayedBy)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].appearance, response?.appearance)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].birthday, response?.birthday)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].img, response?.img)
        assertEquals(MOCK_DAO_LIST_RESPONSE[0].status, response?.status)
    }

    @Test
    fun getCharacterDetailsWithException() = runBlocking {
        every { dao.getCharacterById(1) } throws Exception()

        val response = interactor.getCharacterDetails(1)

        verify { dao.getCharacterById(1) }

        assertTrue(response == null)
    }

    @Test
    fun insertCharacters() = runBlocking {
        every { dao.insertAll(*anyVararg()) } just Runs

        interactor.saveCharacters(MOCK_DAO_LIST_RESPONSE)

        verify { dao.insertAll(*anyVararg()) }
    }
}