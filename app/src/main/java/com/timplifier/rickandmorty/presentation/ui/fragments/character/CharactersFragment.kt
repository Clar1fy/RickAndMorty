package com.timplifier.rickandmorty.presentation.ui.fragments.character

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import com.timplifier.rickandmorty.databinding.FragmentCharactersBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharactersAdapter(this::onItemClick)


    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.e("GayPop", "Loading ")
                }

                is Resource.Error -> {
                    Log.e("GayPop", it.message.toString())


                }
                is Resource.Success -> {
                    it.data?.results?.let { it1 -> characterAdapter.setList(it1) }
                }
            }
        }
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.adapter = characterAdapter
    }

    private fun onItemClick(rickAndMortyCharacter: RickAndMortyCharacter) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                rickAndMortyCharacter.id
            )
        )
    }

}