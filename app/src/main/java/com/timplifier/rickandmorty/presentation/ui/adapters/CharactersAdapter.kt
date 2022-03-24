package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseDiffUtil
import com.timplifier.rickandmorty.common.extensions.setImage
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.databinding.ItemCharactersBinding

class CharactersAdapter(
    private val onItemClick: (id: Int) -> Unit
) :
    PagingDataAdapter<RickAndMortyCharacter, CharactersAdapter.CharactersViewHolder>(
        BaseDiffUtil()
    ) {
    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: RickAndMortyCharacter) {
            binding.apply {
                imCharacter.setImage(character.image)
                tvCharacter.text = character.name
                tvStatus.text = character.status
                tvSpecies.text = character.species
                tvLastKnownLocation.text = character.location.name
                tvFirstSeenIn.text = character.origin.name
                when (character.status) {
                    "Alive" -> {
                        imStatus.setImageResource(R.drawable.alive_status)
                    }
                    "Dead" -> {
                        imStatus.setImageResource(R.drawable.dead_status)
                    }
                    "Unknown" -> {
                        imStatus.setImageResource(R.drawable.unknown_status)
                    }
                }

                root.setOnClickListener {
                    onItemClick(character.id)

                }

            }
        }


    }
}




