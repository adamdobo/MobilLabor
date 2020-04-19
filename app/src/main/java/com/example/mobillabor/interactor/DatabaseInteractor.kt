package com.example.mobillabor.interactor

import com.example.mobillabor.database.dao.BreakingBadCharacterDao
import javax.inject.Inject

class DatabaseInteractor @Inject constructor(
    private val dao: BreakingBadCharacterDao
)