package com.example.mobillabor.presenter

import com.example.mobillabor.MOCK_DAO_LIST_RESPONSE
import com.example.mobillabor.MOCK_QUOTE_RESPONSE
import com.example.mobillabor.dto.Error
import com.example.mobillabor.dto.Success
import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.view.details.CharacterDetailsScreen
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class CharacterDetailsPresenterTest {

    companion object {
        const val TEST_AUTHOR = "TEST AUTHOR"
    }

    private lateinit var dbInteractor: DatabaseInteractor
    private lateinit var apiInteractor: BreakingBadApiInteractor
    private lateinit var screen: CharacterDetailsScreen
    private lateinit var presenter: CharacterDetailsPresenter

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        dbInteractor = mockk()
        apiInteractor = mockk()
        screen = mockk()
        presenter = CharacterDetailsPresenter(
            dbInteractor = dbInteractor,
            apiInteractor = apiInteractor
        )
        presenter.attach(screen)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun getCharacterDetailsWithError() {
        coEvery { dbInteractor.getCharacterDetails(1) } returns null
        every { screen.showErrorPage() } just Runs

        presenter.getCharacterDetails(1)

        verify { screen.showErrorPage() }
    }

    @Test
    fun getCharacterDetails() {
        coEvery { dbInteractor.getCharacterDetails(1) } returns MOCK_DAO_LIST_RESPONSE[0]
        every { screen.showCharacterDetails(any()) } just Runs

        presenter.getCharacterDetails(1)

        verify { screen.showCharacterDetails(any()) }
    }

    @Test
    fun getQuote() {
        coEvery { apiInteractor.getQuote(TEST_AUTHOR) } returns Success(MOCK_QUOTE_RESPONSE)
        every { screen.showQuote(any()) } just Runs

        presenter.getQuoteByAuthor(TEST_AUTHOR)

        verify { screen.showQuote(any()) }
    }

    @Test
    fun getQuoteWithError() {
        coEvery { apiInteractor.getQuote(TEST_AUTHOR) } returns Error(Exception())
        every { screen.showQuoteErrorPage(any()) } just Runs

        presenter.getQuoteByAuthor(TEST_AUTHOR)

        verify { screen.showQuoteErrorPage(any()) }
    }
}