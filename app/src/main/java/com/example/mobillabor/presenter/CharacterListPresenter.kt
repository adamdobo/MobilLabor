package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.network.dto.CharacterListResponse
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.Success
import com.example.mobillabor.view.list.CharacterListScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CharacterListPresenter @Inject constructor(
    private val apiInteractor: BreakingBadApiInteractor,
    private val dbInteractor: DatabaseInteractor
) : BasePresenter<CharacterListScreen>() {

    fun getCharacterList() = runBlocking(Dispatchers.Default) {
        when (val result = apiInteractor.getCharacters()) {
            is Success<CharacterListResponse> -> {
                screen?.showList(result.response as? CharacterListResponse)
            }
            is Error -> screen?.showErrorPage(result.exception)
        }
    }

}