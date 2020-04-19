package com.example.mobillabor.view.details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.R
import com.example.mobillabor.database.model.BreakingBadCharacter
import com.example.mobillabor.network.dto.QuoteResponse
import com.example.mobillabor.presenter.CharacterDetailsPresenter
import com.example.mobillabor.view.getAppComponent
import com.example.mobillabor.view.list.CharacterListActivity.Companion.CHAR_ID
import com.example.mobillabor.view.list.CharacterListActivity.Companion.CHAR_NAME
import javax.inject.Inject

class CharacterDetailsActivity : AppCompatActivity(), CharacterDetailsScreen {

    @Inject
    lateinit var presenter: CharacterDetailsPresenter
    private var characterId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
        getAppComponent().inject(this)

        val name = intent.getStringExtra(CHAR_NAME)
        characterId = intent.getIntExtra(CHAR_ID, 0)

        title = name
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        presenter.getCharacterDetails(characterId)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun showQuote(quoteResponse: QuoteResponse?) {
        //TODO show quote at UI
    }

    override fun showQuoteErrorPage(e: Exception) {
        //TODO show quote error at UI
    }

    override fun showErrorPage() {
        //TODO show error at UI
    }

    override fun showCharacterDetails(details: BreakingBadCharacter) {
        Log.d("DETAILS", "Successfully fetched character details for character: ${details.name}")
        //TODO show details at UI
    }
}
