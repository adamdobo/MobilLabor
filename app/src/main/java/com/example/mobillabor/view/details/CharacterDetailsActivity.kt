package com.example.mobillabor.view.details

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillabor.R
import com.example.mobillabor.dto.QuoteResponse
import com.example.mobillabor.model.BreakingBadCharacter
import com.example.mobillabor.presenter.CharacterDetailsPresenter
import com.example.mobillabor.view.getAppComponent
import com.example.mobillabor.view.list.CharacterListActivity.Companion.CHAR_ID
import com.example.mobillabor.view.list.CharacterListActivity.Companion.CHAR_NAME
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_details.*
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

        quote_button.setOnClickListener {
            presenter.getQuoteByAuthor(title.toString())
        }
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
        character_details_quote.text = quoteResponse?.quote
    }

    override fun showQuoteErrorPage(e: Exception) {
        character_details_quote.text = getString(R.string.no_quote)
    }

    override fun showErrorPage() {
        Snackbar.make(parentLayout, R.string.errorText, Snackbar.LENGTH_LONG).show()
    }

    override fun showCharacterDetails(details: BreakingBadCharacter) {
        Picasso.get().load(details.img).into(character_details_image)
        character_details_name.text = getString(R.string.name, details.name)
        character_details_born.text = getString(R.string.born, details.birthday)
        character_details_nickname.text = getString(R.string.nickname, details.nickname)
        character_details_status.text = getString(R.string.status, details.status)
        character_details_seasons.text = getString(R.string.seasons, TextUtils.join(", ", details.appearance))
        character_details_occupation.text = getString(R.string.occupation, TextUtils.join(", ", details.occupation))
        character_details_actor.text = getString(R.string.actor, details.portrayedBy)
    }
}
