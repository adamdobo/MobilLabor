package com.example.mobillabor.view.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobillabor.R
import com.example.mobillabor.presenter.CharacterListPresenter
import com.example.mobillabor.view.details.CharacterDetailsActivity
import com.example.mobillabor.view.getAppComponent
import com.example.mobillabor.view.model.BreakingBadCharacterListItem
import kotlinx.android.synthetic.main.activity_character_list.*
import javax.inject.Inject

class CharacterListActivity : AppCompatActivity(), CharacterListScreen, CharacterListAdapter.OnListItemClickedListener {

    companion object {
        const val CHAR_NAME = "CHAR_NAME"
        const val CHAR_ID = "CHAR_ID"
        private const val TITLE = "Characters"
    }
    private lateinit var characterListAdapter: CharacterListAdapter

    @Inject
    lateinit var presenter: CharacterListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)
        title = TITLE

        getAppComponent().inject(this)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        presenter.getCharacterList()
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    private fun setupRecyclerView() {
        characterListAdapter = CharacterListAdapter(
            characters = mutableListOf(),
            listener = this
        )
        character_list.apply {
            layoutManager = LinearLayoutManager(this@CharacterListActivity)
            adapter = characterListAdapter
        }
    }

    override fun onListItemClicked(character: BreakingBadCharacterListItem) {
        val intent = Intent(this, CharacterDetailsActivity::class.java)
        intent.putExtra(CHAR_NAME, character.name)
        intent.putExtra(CHAR_ID, character.charId)

        startActivity(intent)
    }

    override fun showList(characters: List<BreakingBadCharacterListItem>?) {
        characterListAdapter.update(characters)
    }

    override fun showErrorPage(exception: Exception) {
        Log.d("NETWORK ERROR", exception.message ?: "Unknown")
        //TODO show error page
    }
}
