package com.example.mobillabor.interactor

import com.example.mobillabor.database.dao.BreakingBadCharacterDao
import com.example.mobillabor.network.BreakingBadApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesDatabaseInteractor(dao: BreakingBadCharacterDao) = DatabaseInteractor(dao)

    @Provides
    @Singleton
    fun provideApiInteractor(api: BreakingBadApi) = BreakingBadApiInteractor(api)

}