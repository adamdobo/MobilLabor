package com.example.mobillabor.view.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillabor.R
import com.example.mobillabor.presenter.CharacterListPresenter
import com.example.mobillabor.view.getAppComponent
import javax.inject.Inject

class CharacterListActivity : AppCompatActivity(), CharacterListScreen {

    @Inject
    private lateinit var presenter: CharacterListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAppComponent().inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
}
