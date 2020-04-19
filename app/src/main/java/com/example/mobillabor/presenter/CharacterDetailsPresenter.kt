package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.network.dto.Error
import com.example.mobillabor.network.dto.QuoteResponse
import com.example.mobillabor.network.dto.Success
import com.example.mobillabor.view.details.CharacterDetailsScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CharacterDetailsPresenter @Inject constructor(
    private val apiInteractor: BreakingBadApiInteractor,
    private val dbInteractor: DatabaseInteractor
) : BasePresenter<CharacterDetailsScreen>() {

    fun getQuoteByAuthor(author: String) = runBlocking(Dispatchers.Default) {
        when (val result = apiInteractor.getQuote(author)) {
            is Success<QuoteResponse> -> screen?.showQuote(result.response as? QuoteResponse)
            is Error -> screen?.showErrorPage(result.exception)
        }
    }

    fun getCharacterDetails(id: Int) {
        //TODO get character from DB
    }

}