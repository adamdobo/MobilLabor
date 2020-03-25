package com.example.mobillabor.view

import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.InitApp

fun AppCompatActivity.getAppComponent() =
    (this.applicationContext as InitApp).appComponent