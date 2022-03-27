package com.timplifier.rickandmorty.presentation.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.databinding.FragmentCharactersBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.CharactersAdapter
import com.timplifier.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterListAdapter = CharactersAdapter(this::onItemClick)
    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.apply {
            adapter = characterListAdapter
            val linearLayoutManager = LinearLayoutManager(context)
            addOnScrollListener(object :
                PaginationScrollListener(linearLayoutManager, { viewModel.fetchCharacters() }) {
                override fun isLoading() = viewModel.isLoading
            }
            )


        }
    }


    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                characterListAdapter.su


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