package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.newSingleThreadContext
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideCharacterDetailsPresenter(apiInteractor: BreakingBadApiInteractor, context: CoroutineContext) = CharacterDetailsPresenter(context, apiInteractor)

    @Provides
    @Singleton
    fun provideCharacterListPresenter(apiInteractor: BreakingBadApiInteractor, context: CoroutineContext) = CharacterListPresenter(context, apiInteractor)

}