package com.example.mobillabor.dto

sealed class NetworkResponse<out T: Any>

class Success<out T: Any>(val response: T): NetworkResponse<T>()

class Error(val exception: Exception): NetworkResponse<Nothing>()