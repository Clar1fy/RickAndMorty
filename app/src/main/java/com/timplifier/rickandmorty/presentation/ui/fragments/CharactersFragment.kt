package com.timplifier.rickandmorty.presentation.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.databinding.FragmentCharactersBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(com.timplifier.rickandmorty.databinding.FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharactersAdapter()


    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    println("пошел нах")
                }

                is Resource.Error -> {


                }
                is Resource.Success -> {
                }
            }
        }
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.adapter =
    }

}