package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideCharacterDetailsPresenter(apiInteractor: BreakingBadApiInteractor, scope: CoroutineScope) = CharacterDetailsPresenter(scope, apiInteractor)

    @Provides
    @Singleton
    fun provideCharacterListPresenter(apiInteractor: BreakingBadApiInteractor, scope: CoroutineScope) = CharacterListPresenter(scope, apiInteractor)

}