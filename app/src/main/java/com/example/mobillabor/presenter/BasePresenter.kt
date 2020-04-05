package com.example.mobillabor.presenter

abstract class BasePresenter<S> {
    var screen: S? = null

    fun attach(screen: S) {
        this.screen = screen
    }

    fun detach() {
        this.screen = null
    }
}