package com.example.mobillabor.presenter

import com.example.mobillabor.dto.CharacterListResponse
import com.example.mobillabor.dto.Error
import com.example.mobillabor.dto.Success
import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.mapper.toBreakingBadCharacter
import com.example.mobillabor.mapper.toBreakingBadCharacterListItem
import com.example.mobillabor.view.list.CharacterListScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListPresenter @Inject constructor(
    private val apiInteractor: BreakingBadApiInteractor,
    private val dbInteractor: DatabaseInteractor
) : BasePresenter<CharacterListScreen>() {

    fun getCharacterList() = GlobalScope.launch(Dispatchers.Main) {
        val dbResult = dbInteractor.getAllCharacters()
        if(dbResult.isEmpty()) {
            when (val result = apiInteractor.getCharacters()) {
                is Success<CharacterListResponse> -> {
                    screen?.showList(result.response.characters?.map { it.toBreakingBadCharacterListItem() })
                    saveCharactersToDatabase(result.response)
                }
                is Error -> screen?.showErrorPage(result.exception)
            }
        } else {
            screen?.showList(dbResult.map { it.toBreakingBadCharacterListItem() })
        }
    }

    private suspend fun saveCharactersToDatabase(response: CharacterListResponse) {
        response.characters?.map { it.toBreakingBadCharacter() }?.let {
            dbInteractor.saveCharacters(it)
        }
    }

}