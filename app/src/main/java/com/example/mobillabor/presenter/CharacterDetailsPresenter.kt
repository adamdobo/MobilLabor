package com.example.mobillabor.presenter

import com.example.mobillabor.dto.Error
import com.example.mobillabor.dto.QuoteResponse
import com.example.mobillabor.dto.Success
import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import com.example.mobillabor.view.details.CharacterDetailsScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsPresenter @Inject constructor(
    private val apiInteractor: BreakingBadApiInteractor,
    private val dbInteractor: DatabaseInteractor
) : BasePresenter<CharacterDetailsScreen>() {

    fun getQuoteByAuthor(author: String) = GlobalScope.launch(Dispatchers.Main) {
        when (val result = apiInteractor.getQuote(author)) {
            is Success<*> -> screen?.showQuote(result.response as QuoteResponse)
            is Error -> screen?.showQuoteErrorPage(result.exception)
        }
    }

    fun getCharacterDetails(id: Int) = GlobalScope.launch(Dispatchers.Main) {
        when(val details = dbInteractor.getCharacterDetails(id)) {
            null -> screen?.showErrorPage()
            else -> screen?.showCharacterDetails(details)
        }
    }
}