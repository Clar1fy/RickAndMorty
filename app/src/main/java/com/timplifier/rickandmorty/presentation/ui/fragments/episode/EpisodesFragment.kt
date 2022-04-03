package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.extensions.isInternetConnectionAvailable
import com.timplifier.rickandmorty.common.extensions.submitData
import com.timplifier.rickandmorty.databinding.FragmentEpisodesBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import com.timplifier.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {
    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodesAdapter = EpisodesAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.apply {

            adapter = episodesAdapter
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addOnScrollListener(object :
                PaginationScrollListener(linearLayoutManager, { viewModel.fetchEpisodes() }) {
                override fun isLoading() = viewModel.isLoading
            }
            )
        }

    }


    override fun setupObserver() {
        gatherToEpisodes()
        gatherToLocalEpisodes()
    }

    private fun gatherToLocalEpisodes() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.episodesLocalState.observe(viewLifecycleOwner) {
                episodesAdapter.submitData(it)
            }
        }
    }

    private fun gatherToEpisodes() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.episodesState.observe(viewLifecycleOwner) {
                episodesAdapter.submitData(it.results)

            }
        }

    }

    override fun setupRequest() {

        if (viewModel.episodesState.value == null && requireContext().isInternetConnectionAvailable(
               requireContext()
            )
        )
            viewModel.fetchEpisodes()
        else
            viewModel.getEpisodes()
    }
}
