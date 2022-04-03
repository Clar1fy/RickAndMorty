package com.timplifier.rickandmorty.presentation.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.extensions.isInternetConnectionAvailable
import com.timplifier.rickandmorty.common.extensions.submitData
import com.timplifier.rickandmorty.databinding.FragmentCharactersBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.CharactersAdapter
import com.timplifier.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val charactersAdapter = CharactersAdapter(this::onItemClick)
    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.apply {
            adapter = charactersAdapter
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addOnScrollListener(object :
                PaginationScrollListener(linearLayoutManager, { viewModel.fetchCharacters() }) {
                override fun isLoading() = viewModel.isLoading

            }
            )
        }
    }

    override fun setupObserver() {
        gatherToCharacters()
        gatherToLocalCharacters()
    }

    override fun setupRequest() {
        if (viewModel.characterState.value == null && requireContext().isInternetConnectionAvailable(
                requireContext()
            )

        )
            viewModel.fetchCharacters()
        else viewModel.getCharacters()
    }


    private fun gatherToLocalCharacters() {
        viewModel.characterLocalState.observe(viewLifecycleOwner) {
            charactersAdapter.submitData(it)

        }
    }

    private fun gatherToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.characterState.observe(viewLifecycleOwner) {

                charactersAdapter.submitData(it.results)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                id
            )
        )

    }

}