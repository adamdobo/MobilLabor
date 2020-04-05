package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.view.list.CharacterListScreen
import javax.inject.Inject

class CharacterListPresenter @Inject constructor(
    val apiInteractor: BreakingBadApiInteractor
) : BasePresenter<CharacterListScreen>() {
}