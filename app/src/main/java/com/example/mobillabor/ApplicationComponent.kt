package com.example.mobillabor

import com.example.mobillabor.database.DatabaseModule
import com.example.mobillabor.interactor.InteractorModule
import com.example.mobillabor.network.NetworkModule
import com.example.mobillabor.presenter.PresenterModule
import com.example.mobillabor.view.details.CharacterDetailsActivity
import com.example.mobillabor.view.list.CharacterListActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, InteractorModule::class, PresenterModule::class, DatabaseModule::class])
@Singleton
interface ApplicationComponent {

    fun inject(activity: CharacterListActivity)
    fun inject(activity: CharacterDetailsActivity)

}