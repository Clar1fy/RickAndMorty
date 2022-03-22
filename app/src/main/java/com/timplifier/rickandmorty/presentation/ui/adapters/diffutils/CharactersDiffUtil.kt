package com.timplifier.rickandmorty.presentation.ui.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

class CharactersDiffUtil : DiffUtil.ItemCallback<RickAndMortyCharacter>() {


    override fun areItemsTheSame(
        oldItem: RickAndMortyCharacter,
        newItem: RickAndMortyCharacter
    ) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: RickAndMortyCharacter,
        newItem: RickAndMortyCharacter
    ) = oldItem == newItem

}