package com.example.mobillabor.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideDatabase(): BreakingBadDatabase = Room.databaseBuilder(
        context.applicationContext,
        BreakingBadDatabase::class.java,
        "breakingbad-db"
    ).build()

    @Provides
    @Singleton
    fun provideDao(db: BreakingBadDatabase) = db.breakingBadCharacterDao()
}