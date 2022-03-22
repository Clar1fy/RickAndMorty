package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import com.timplifier.rickandmorty.databinding.ItemLocationsBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.diffutils.LocationsDiffUtil

class LocationsAdapter :
    ListAdapter<RickAndMortyLocation, LocationsAdapter.LocationsViewHolder>(LocationsDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    class LocationsViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyLocation: RickAndMortyLocation) {
            binding.tvLocationName.text = rickAndMortyLocation.name
            binding.tvLocationType.text = rickAndMortyLocation.type
            binding.tvDimensionName.text = rickAndMortyLocation.dimension


        }


    }
}