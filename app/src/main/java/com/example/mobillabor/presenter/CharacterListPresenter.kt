package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.network.dto.CharacterListResponse
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.Success
import com.example.mobillabor.view.list.CharacterListScreen
import kotlinx.coroutines.*
import java.util.concurrent.Executor
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CharacterListPresenter @Inject constructor(
    private val networkContext: CoroutineContext,
    private val apiInteractor: BreakingBadApiInteractor
) : BasePresenter<CharacterListScreen>() {

    fun getCharacterList() {
        CoroutineScope(networkContext).launch {
            when(val result = apiInteractor.getCharacters()) {
                is Success<*> -> screen?.showList(result.response as? CharacterListResponse)
                is Error -> screen?.showErrorPage(result.exception)
            }
        }
    }

}