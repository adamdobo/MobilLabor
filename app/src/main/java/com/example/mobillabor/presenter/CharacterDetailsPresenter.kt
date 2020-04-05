package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.view.details.CharacterDetailsScreen
import javax.inject.Inject

class CharacterDetailsPresenter @Inject constructor(
    val apiInteractor: BreakingBadApiInteractor
) : BasePresenter<CharacterDetailsScreen>()