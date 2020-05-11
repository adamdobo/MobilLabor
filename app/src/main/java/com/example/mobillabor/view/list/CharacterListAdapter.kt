package com.example.mobillabor.view.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobillabor.R
import com.example.mobillabor.view.model.BreakingBadCharacterListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_list_item.view.*

class CharacterListAdapter(
    private var characters: MutableList<BreakingBadCharacterListItem>,
    private val listener: OnListItemClickedListener,
    val context: Context
): RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(characters[position]) {
            holder.characterName.text = name
            Picasso.get().load(img).into(holder.characterImage)
            holder.character = this
        }
    }

    fun update(list: List<BreakingBadCharacterListItem>?) {
        characters.clear()
        characters = list?.toMutableList() ?: mutableListOf()
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        val removedCharacter = characters.removeAt(position)
        listener.onListItemRemoved(removedCharacter)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val characterName: TextView = view.character_name
        val characterImage: ImageView = view.character_image
        lateinit var character: BreakingBadCharacterListItem

        init {
            view.setOnClickListener {
                listener.onListItemClicked(character)
            }
        }
    }

    interface OnListItemClickedListener {
        fun onListItemClicked(character: BreakingBadCharacterListItem)
        fun onListItemRemoved(character: BreakingBadCharacterListItem)
    }
}