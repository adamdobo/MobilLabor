package com.example.mobillabor.presenter

import com.example.mobillabor.MOCK_CHARACTER_LIST_RESPONSE
import com.example.mobillabor.MOCK_DAO_LIST_RESPONSE
import com.example.mobillabor.dto.CharacterListResponse
import com.example.mobillabor.dto.Error
import com.example.mobillabor.dto.Success
import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.view.list.CharacterListScreen
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class CharacterListPresenterTest {

    private lateinit var dbInteractor: DatabaseInteractor
    private lateinit var apiInteractor: BreakingBadApiInteractor
    private lateinit var screen: CharacterListScreen
    private lateinit var presenter: CharacterListPresenter

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        dbInteractor = mockk()
        apiInteractor = mockk()
        screen = mockk()
        presenter = CharacterListPresenter(
            dbInteractor = dbInteractor,
            apiInteractor = apiInteractor
        )
        presenter.attach(screen)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun teardown() {
        presenter.detach()
    }

    @Test
    fun getCharacterListWithNetworkCall() {
        coEvery { dbInteractor.getAllCharacters() } returns emptyList()
        coEvery { apiInteractor.getCharacters() } returns Success(
            CharacterListResponse(MOCK_CHARACTER_LIST_RESPONSE)
        )
        every { screen.showList(any()) } just Runs
        coEvery { dbInteractor.saveCharacters(any()) } just Runs

        presenter.getCharacterList()

        verify { screen.showList(any()) }
        coVerify { dbInteractor.saveCharacters(any()) }
    }

    @Test
    fun getCharacterListWithNetworkException() {
        coEvery { dbInteractor.getAllCharacters() } returns emptyList()
        coEvery { apiInteractor.getCharacters() } returns Error(Exception())
        every { screen.showErrorPage(any()) } just Runs

        presenter.getCharacterList()

        verify { screen.showErrorPage(any()) }
    }

    @Test
    fun getCharacterListFromDB() {
        coEvery { dbInteractor.getAllCharacters() } returns MOCK_DAO_LIST_RESPONSE
        every { screen.showList(any()) } just Runs

        presenter.getCharacterList()

        coVerify(exactly = 0) { apiInteractor.getCharacters() }
        verify { screen.showList(any()) }
    }

    @Test
    fun removeCharacter() {
        coEvery { dbInteractor.removeCharacter(1) } returns Unit

        presenter.removeCharacter(1)

        coVerify { dbInteractor.removeCharacter(1) }
    }
}