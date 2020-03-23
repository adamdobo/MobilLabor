package com.example.mobillabor.view.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R

class CharacterListActivity : AppCompatActivity(), CharacterListScreen {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
