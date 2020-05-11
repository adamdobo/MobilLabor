package com.example.mobillabor.interactor

import com.example.mobillabor.MOCK_CHARACTER_LIST_RESPONSE
import com.example.mobillabor.MOCK_QUOTE_RESPONSE
import com.example.mobillabor.dto.CharacterListResponse
import com.example.mobillabor.dto.Error
import com.example.mobillabor.dto.QuoteResponse
import com.example.mobillabor.dto.Success
import com.example.mobillabor.network.BreakingBadApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BreakingBadApiInteractorTest {

    companion object {
        const val TEST_AUTHOR = "TEST_AUTHOR"
    }

    private lateinit var api: BreakingBadApi
    private lateinit var interactor: BreakingBadApiInteractor

    @Before
    fun setup() {
        api = mockk()
        interactor = BreakingBadApiInteractor(api)
    }

    @Test
    fun getCharacters() = runBlocking {
        coEvery { api.getCharacters() } returns MOCK_CHARACTER_LIST_RESPONSE

        val response = interactor.getCharacters()

        coVerify { api.getCharacters() }

        assertTrue(response is Success)
        response as Success<CharacterListResponse>
        assertEquals(MOCK_CHARACTER_LIST_RESPONSE.size, response.response.characters?.size)
    }

    @Test
    fun getCharactersWithError() = runBlocking {
        coEvery { api.getCharacters() } throws Exception()

        val response = interactor.getCharacters()

        coVerify { api.getCharacters() }

        assertTrue(response is Error)
    }

    @Test
    fun getQuote() = runBlocking {
        coEvery { api.getRandomQuoteByCharacter(TEST_AUTHOR) } returns listOf(
            MOCK_QUOTE_RESPONSE
        )

        val response = interactor.getQuote(TEST_AUTHOR)

        coVerify { api.getRandomQuoteByCharacter(TEST_AUTHOR) }

        assertTrue(response is Success)
        response as Success<QuoteResponse>
        assertEquals(MOCK_QUOTE_RESPONSE.author, response.response.author)
        assertEquals(MOCK_QUOTE_RESPONSE.quote, response.response.quote)
    }

    @Test
    fun getQuoteWithEmptyAnswer() = runBlocking {
        coEvery { api.getRandomQuoteByCharacter(TEST_AUTHOR) } returns emptyList()

        val response = interactor.getQuote(TEST_AUTHOR)

        coVerify { api.getRandomQuoteByCharacter(TEST_AUTHOR) }

        assertTrue(response is Error)
    }

    @Test
    fun getQuoteWithException() = runBlocking {
        coEvery { api.getRandomQuoteByCharacter(TEST_AUTHOR) } throws Exception()

        val response = interactor.getQuote(TEST_AUTHOR)

        coVerify { api.getRandomQuoteByCharacter(TEST_AUTHOR) }

        assertTrue(response is Error)
    }
}