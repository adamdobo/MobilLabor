package com.example.mobillabor

import android.app.Application

class InitApp : Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.create()
    }

}