package com.timplifier.rickandmorty.presentation.ui.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode

class EpisodesDiffUtil : DiffUtil.ItemCallback<RickAndMortyEpisode>() {
    override fun areItemsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ) = oldItem == newItem
}