package com.example.mobillabor.view.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobillabor.R
import com.example.mobillabor.database.model.BreakingBadCharacter
import com.example.mobillabor.network.dto.CharacterListResponse
import com.example.mobillabor.presenter.CharacterListPresenter
import com.example.mobillabor.view.details.CharacterDetailsActivity
import com.example.mobillabor.view.getAppComponent
import kotlinx.android.synthetic.main.activity_character_list.*
import javax.inject.Inject

class CharacterListActivity : AppCompatActivity(), CharacterListScreen, CharacterListAdapter.OnListItemClickedListener {

    private lateinit var characterListAdapter: CharacterListAdapter

    @Inject
    lateinit var presenter: CharacterListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

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

    override fun onListItemClicked(character: BreakingBadCharacter) {
        startActivity(Intent(this, CharacterDetailsActivity::class.java))
    }

    override fun showList(characters: CharacterListResponse?) {
        characterListAdapter.update(characters)
    }

    override fun showErrorPage(exception: Exception) {
        Log.d("NETWORK ERROR", exception.message ?: "Unknown")
        //TODO show error page
    }
}
