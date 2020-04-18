package com.example.mobillabor.interactor

import com.example.mobillabor.network.BreakingBadApi
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.newSingleThreadContext
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    fun providesCoroutineScope(): CoroutineScope = CoroutineScope(newSingleThreadContext("networkIO"))

    @Provides
    @Singleton
    fun provideApiInteractor(api: BreakingBadApi) = BreakingBadApiInteractor(api)

}