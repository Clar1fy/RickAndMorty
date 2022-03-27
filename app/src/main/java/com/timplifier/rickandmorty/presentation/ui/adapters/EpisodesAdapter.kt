package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.base.BaseDiffUtil
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.databinding.ItemEpisodesBinding

class EpisodesAdapter :
    ListAdapter<RickAndMortyEpisode, EpisodesAdapter.EpisodeViewHolder>(BaseDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
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