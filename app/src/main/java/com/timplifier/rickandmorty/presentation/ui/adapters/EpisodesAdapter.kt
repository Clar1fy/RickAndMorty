package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.databinding.ItemEpisodesBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.diffutils.EpisodesDiffUtil

class EpisodesAdapter :
    ListAdapter<RickAndMortyEpisode, EpisodesAdapter.EpisodeViewHolder>(EpisodesDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    inner class EpisodeViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episode: RickAndMortyEpisode) {

            binding.apply {
                tvEpisodeName.text = episode.name
                tvAirDate.text = episode.air_date
                tvEpisodeCode.text = episode.episode
            }
        }

    }


}