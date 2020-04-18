package com.example.mobillabor.network.dto

import kotlin.Exception

sealed class NetworkResponse

class Success<T>(val response: T): NetworkResponse()

class Error(val exception: Exception): NetworkResponse()