package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.databinding.ItemCharactersBinding

class CharactersListAdapter : ListAdapter<RickAndMortyCharacter, CharactersViewHolder>() {


    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        TODO("Not yet implemented")
    }
}

class CharactersViewHolder(binding: ItemCharactersBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(character: RickAndMortyCharacter) {


    }

}
