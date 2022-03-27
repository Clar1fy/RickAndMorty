package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter

class PagingLoadStateAdapter : RecyclerView.Adapter<PagingLoadStateAdapter.LoadStateViewHolder>() {
    private var list: List<RickAndMortyCharacter> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PagingLoadStateAdapter.LoadStateViewHolder {
        TODO("Not yet implemented")
    }

    fun setList(list: List<RickAndMortyCharacter>) {
        this.list = list

    }

    override fun onBindViewHolder(
        holder: PagingLoadStateAdapter.LoadStateViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class LoadStateViewHolder : RecyclerView.ViewHolder {

    }
}
