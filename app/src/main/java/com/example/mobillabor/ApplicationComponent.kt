package com.example.mobillabor

import com.example.mobillabor.interactor.ApiModule
import com.example.mobillabor.network.NetworkModule
import com.example.mobillabor.presenter.PresenterModule
import com.example.mobillabor.view.details.CharacterDetailsActivity
import com.example.mobillabor.view.list.CharacterListActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, ApiModule::class, PresenterModule::class])
@Singleton
interface ApplicationComponent {

    fun inject(activity: CharacterListActivity)
    fun inject(activity: CharacterDetailsActivity)

}