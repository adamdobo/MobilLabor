package com.example.mobillabor.interactor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesDatabaseInteractor() = DatabaseInteractor()

    @Provides
    @Singleton
    fun provideApiInteractor() = BreakingBadApiInteractor()

}