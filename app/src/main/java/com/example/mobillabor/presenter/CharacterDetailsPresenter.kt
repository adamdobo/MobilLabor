package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.QuoteResponse
import com.example.mobillabor.network.dto.Success
import com.example.mobillabor.view.details.CharacterDetailsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsPresenter @Inject constructor(
    private val scope: CoroutineScope,
    private val apiInteractor: BreakingBadApiInteractor
) : BasePresenter<CharacterDetailsScreen>() {

    fun getQuoteByAuthor(author: String) {
        scope.launch {
            when(val result = apiInteractor.getQuote(author)) {
                is Success<*> -> screen?.showQuote(result.response as? QuoteResponse)
                is Error -> screen?.showErrorPage(result.exception)
            }
        }
    }

    fun getCharacterDetails(id: Int) {
        //TODO get character from DB
    }

}