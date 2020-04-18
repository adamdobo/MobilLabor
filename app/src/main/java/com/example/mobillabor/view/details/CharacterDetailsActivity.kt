package com.example.mobillabor.view.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.R
import com.example.mobillabor.network.dto.QuoteResponse
import com.example.mobillabor.presenter.CharacterDetailsPresenter
import com.example.mobillabor.view.getAppComponent
import javax.inject.Inject

class CharacterDetailsActivity : AppCompatActivity(), CharacterDetailsScreen {

    @Inject
    lateinit var presenter: CharacterDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

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

    override fun showQuote(quoteResponse: QuoteResponse?) {
        //TODO show quote at UI
    }

    override fun showErrorPage(exception: Exception) {
        //TODO show error page
    }
}
