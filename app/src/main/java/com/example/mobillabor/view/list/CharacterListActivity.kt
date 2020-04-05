package com.example.mobillabor.view.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobillabor.R
import com.example.mobillabor.model.BreakingBadCharacter
import com.example.mobillabor.presenter.CharacterListPresenter
import com.example.mobillabor.view.details.CharacterDetailsActivity
import com.example.mobillabor.view.getAppComponent
import kotlinx.android.synthetic.main.activity_character_list.*
import javax.inject.Inject

class CharacterListActivity : AppCompatActivity(), CharacterListScreen, CharacterListAdapter.OnListItemClickedListener {

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
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    private fun setupRecyclerView() {
        character_list.apply {
            layoutManager = LinearLayoutManager(this@CharacterListActivity)
            adapter = CharacterListAdapter(
                characters = listOf(
                    BreakingBadCharacter("TEST CHARACTER 1"),
                    BreakingBadCharacter("TEST CHARACTER 2"),
                    BreakingBadCharacter("TEST CHARACTER 3"),
                    BreakingBadCharacter("TEST CHARACTER 4")
                ),
                listener = this@CharacterListActivity
            )
        }
    }

    override fun onListItemClicked(character: BreakingBadCharacter) {
        startActivity(Intent(this, CharacterDetailsActivity::class.java))
    }
}
