package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.common.extensions.setImage
import com.timplifier.rickandmorty.data.remote.dtos.RickAndMortyCharacter
import com.timplifier.rickandmorty.databinding.ItemCharactersBinding

class CharactersAdapter(
    private val onItemClick: (RickAndMortyCharacter) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private var list: List<RickAndMortyCharacter> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =

        CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =
        list.size

    fun setList(list: List<RickAndMortyCharacter>) {
        this.list = list
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: RickAndMortyCharacter) {
            binding.imCharacter.setImage(character.image)
            binding.tvCharacter.text = character.name
            binding.root.setOnClickListener {
                onItemClick(character)
            }


        }


    }
}
