package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.resource.Resource
import com.timplifier.rickandmorty.databinding.FragmentEpisodesBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {
    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val adapter = EpisodesAdapter()


    private fun setupAdapter() {
        binding.recyclerview.adapter = adapter
    }

    override fun setupViews() {
        setupAdapter()
        subscribeToLocations()

    }

    override fun setupObserver() {
        subscribeToLocations()
    }

    private fun subscribeToLocations() {
        viewModel.fetchEpisodes().observe(viewLifecycleOwner) {

            when (it) {

                is Resource.Loading -> {
                    Log.e("gaypop", "Loading")
                }
                is Resource.Error -> {
                    Log.e("gaypop", it.message.toString())

                }
                is Resource.Success -> {
                    it.data?.results?.let { it1 -> adapter.setList(it1) }
                }

            }
        }
    }

}