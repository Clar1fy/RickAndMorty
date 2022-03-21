package com.timplifier.rickandmorty.presentation.ui.fragments.character.details

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.databinding.FragmentCharacterDetailsBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>(
        R.layout.fragment_character_details
    ) {
    override val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private val adapter = CharactersAdapter(this::onClick)


    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {

        binding.recyclerview.adapter = adapter
    }

    override fun setupObserver() {
        subscribeToCharacters()
    }


    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchSingleCharacter(args.characterId).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("GayPop", "Loading ")
                    }

                    is Resource.Error -> {
                        Log.e("GayPop", it.message.toString())


                    }
                    is Resource.Success -> {
                        it.data?.results?.let { it1 -> adapter.setList(it1)
                        }


                    }
                }
            }

        }
    }

    private fun onClick(id: Int) {


    }


}