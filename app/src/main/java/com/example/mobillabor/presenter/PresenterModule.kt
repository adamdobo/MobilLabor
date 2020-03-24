package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideCharacterDetailsPresenter(apiInteractor: BreakingBadApiInteractor) = CharacterDetailsPresenter(apiInteractor)

    @Provides
    @Singleton
    fun provideCharacterListPresenter(apiInteractor: BreakingBadApiInteractor) = CharacterListPresenter(apiInteractor)

}