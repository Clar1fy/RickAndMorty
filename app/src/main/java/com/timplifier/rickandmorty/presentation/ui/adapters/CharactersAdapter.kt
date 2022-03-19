package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.common.extensions.setImage
import com.timplifier.rickandmorty.databinding.ItemCharactersBinding

class CharactersAdapter(
    private
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private var list: List = ArrayList()
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

    fun setList(list: List) {
        this.list = list
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(any: Any) {
            binding.imCharacter.setImage()


        }


    }
}
