package com.example.mobillabor.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Named("apiUrl")
    fun provideApiUrl() = "https://www.breakingbadapi.com/api/"

    @Provides
    @Singleton
    fun provideOkHttp() =
        OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient,
                   @Named("apiUrl") baseUrl: String) =
        Retrofit.Builder().client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(BreakingBadApi::class.java)
}