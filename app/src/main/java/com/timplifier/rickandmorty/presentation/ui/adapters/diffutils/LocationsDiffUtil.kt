package com.timplifier.rickandmorty.presentation.ui.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

class LocationsDiffUtil : DiffUtil.ItemCallback<RickAndMortyLocation>() {
    override fun areItemsTheSame(
        oldItem: RickAndMortyLocation,
        newItem: RickAndMortyLocation
    ) = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: RickAndMortyLocation,
        newItem: RickAndMortyLocation
    ) =
        oldItem == newItem
}