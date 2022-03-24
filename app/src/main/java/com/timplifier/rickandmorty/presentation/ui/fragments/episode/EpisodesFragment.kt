package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.databinding.FragmentEpisodesBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import com.timplifier.rickandmorty.presentation.ui.adapters.PagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {
    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val adapter = EpisodesAdapter()
    override fun setupViews() {
        setupAdapter()

    }


    private fun setupAdapter() {
        binding.recyclerview.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PagingLoadStateAdapter(),
            footer = PagingLoadStateAdapter()

        )
    }


    override fun setupObserver() {
        subscribeToEpisodes()
    }

    private fun subscribeToEpisodes() {
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.fetchEpisodes().collectLatest {
                adapter.submitData(it)

                adapter.addLoadStateListener { loadState ->
                    binding.progressBar.isVisible = loadState.refresh is LoadState.Loading
                }
            }
        }

    }

}