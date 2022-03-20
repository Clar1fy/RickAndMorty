package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import com.timplifier.rickandmorty.databinding.ItemEpisodesBinding

class EpisodesAdapter : RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder>() {
    private var list: List<RickAndMortyEpisode> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =
        list.size


    inner class EpisodeViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyEpisode: RickAndMortyEpisode) {


        }

    }

}