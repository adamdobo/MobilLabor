package com.example.mobillabor.view.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R

class CharacterDetailsActivity : AppCompatActivity(), CharacterDetailsScreen {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
    }
}
