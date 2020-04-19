package com.example.mobillabor.presenter

import com.example.mobillabor.interactor.BreakingBadApiInteractor
import com.example.mobillabor.interactor.DatabaseInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule() {

    @Provides
    @Singleton
    fun provideCharacterDetailsPresenter(apiInteractor: BreakingBadApiInteractor, dbInteractor: DatabaseInteractor) =
        CharacterDetailsPresenter(apiInteractor, dbInteractor)

    @Provides
    @Singleton
    fun provideCharacterListPresenter(apiInteractor: BreakingBadApiInteractor, dbInteractor: DatabaseInteractor) =
        CharacterListPresenter(apiInteractor, dbInteractor)

}