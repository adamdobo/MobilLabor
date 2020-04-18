package com.example.mobillabor.network.dto

import java.lang.Exception

sealed class NetworkResponse

class Success<T>(val response: T): NetworkResponse()

class Error(val exception: Exception): NetworkResponse()