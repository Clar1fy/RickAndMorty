package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.base.BaseDiffUtil
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.databinding.ItemCharactersBinding

class CharactersPagingAdapter() :
    PagingDataAdapter<RickAndMortyCharacter, CharactersPagingAdapter.CharactersViewHolder>(
        BaseDiffUtil()
    ) {
    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        TODO("Not yet implemented")
    }
}