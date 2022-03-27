package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.databinding.FragmentEpisodesBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import com.timplifier.rickandmorty.utils.PaginationScrollListener
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
        binding.recyclerview.apply {

            val linearLayoutManager = LinearLayoutManager(context)
            adapter = adapter
            addOnScrollListener(object :
                PaginationScrollListener(linearLayoutManager, { viewModel.fetchEpisodes() }) {
                override fun isLoading() = viewModel.isLoading
            }
            )
        }

    }


    override fun setupObserver() {
        subscribeToEpisodes()
    }

    private fun subscribeToEpisodes() {
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.fetchEpisodes().collectLatest {
                adapter.submitData(it)

            }
        }

    }

}