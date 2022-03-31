package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseDiffUtil
import com.timplifier.rickandmorty.common.extensions.setImage
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.databinding.ItemCharactersBinding
import com.timplifier.rickandmorty.databinding.ItemFooterLoaderBinding

class CharacterAdapterWithProgressBar(
    private val onItemClick: (id: Int) -> Unit
) :
    ListAdapter<RickAndMortyCharacter, RecyclerView.ViewHolder>(BaseDiffUtil()) {
    private val VIEW_TYPE_ITEM: Int = 1
    private val VIEW_TYPE_LOADING: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            return CharacterViewHolder(
                ItemCharactersBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            return ProgressBarViewHolder(
                ItemFooterLoaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder ->
                getItem(position).let { holder.onCharactersBind(it) }
            is ProgressBarViewHolder ->
                getItem(position).let { holder.onProgressBarBind(it) }
        }


    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
        if (getItem(position) != null) {

            return VIEW_TYPE_ITEM
        } else {
            return VIEW_TYPE_LOADING
        }
    }

    inner class CharacterViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onCharactersBind(character: RickAndMortyCharacter) {
            binding.apply {
                imCharacter.setImage(character.image)
                tvCharacter.text = character.name
                tvStatus.text = character.status
                tvSpecies.text = character.species
                tvLastKnownLocation.text = character.location.name
                tvFirstSeenIn.text = character.origin.name
                when (character.status) {
                    "Alive" -> imStatus.setImageResource(R.drawable.alive_status)

                    "Dead" -> imStatus.setImageResource(R.drawable.dead_status)

                    "unknown" -> imStatus.setImageResource(R.drawable.unknown_status)

                }

                root.setOnClickListener {
                    onItemClick(character.id)

                }

            }


        }


    }

    inner class ProgressBarViewHolder(private val binding: ItemFooterLoaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onProgressBarBind(it: RickAndMortyCharacter?) {
            binding.progressBar.isIndeterminate = true


        }


    }
}
