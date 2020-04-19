package com.example.mobillabor

import android.app.Application
import com.example.mobillabor.database.DatabaseModule

class InitApp : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .databaseModule(DatabaseModule(this)).build()
    }

}