package com.timplifier.rickandmorty.presentation.ui.fragments.character.details

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.extensions.setCircularImage
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>(
        R.layout.fragment_character_details
    ) {


    override val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()


    override fun setupViews() {
        activity?.actionBar?.hide()
    }

    override fun setupObserver() {
        subscribeToCharacters()

    }

    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchSingleCharacter(args.characterId).collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("anime", "Loading")
                    }
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                    }
                    is Resource.Success -> {
                        binding.apply {
                            it.data?.image?.let { it1 -> imCharacter.setCircularImage(it1) }
                            tvCharacter.text = it.data?.name
                            tvGender.text = it.data?.gender
                        }
                    }
                }
            }
        }
    }


}