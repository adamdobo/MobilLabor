package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.view.details.CharacterDetailsScreen
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CharacterDetailsPresenter @Inject constructor(
    val networkContext: CoroutineContext,
    val apiInteractor: BreakingBadApiInteractor
) : BasePresenter<CharacterDetailsScreen>()