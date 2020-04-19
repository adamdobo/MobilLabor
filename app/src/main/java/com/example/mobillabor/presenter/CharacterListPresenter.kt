package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.network.dto.CharacterListResponse
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.Success
import com.example.mobillabor.network.dto.mapper.toBreakingBadCharacter
import com.example.mobillabor.view.list.CharacterListScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CharacterListPresenter @Inject constructor(
    private val apiInteractor: BreakingBadApiInteractor,
    private val dbInteractor: DatabaseInteractor
) : BasePresenter<CharacterListScreen>() {

    fun getCharacterList() = runBlocking(Dispatchers.Default) {
        val dbResult = dbInteractor.getAllCharacters()
        if(dbResult.isEmpty()) {
            when (val result = apiInteractor.getCharacters()) {
                is Success<CharacterListResponse> -> {
                    screen?.showList(result.response.characters?.map { it.toBreakingBadCharacter() })
                }
                is Error -> screen?.showErrorPage(result.exception)
            }
        } else {
            screen?.showList(dbResult)
        }
    }

}