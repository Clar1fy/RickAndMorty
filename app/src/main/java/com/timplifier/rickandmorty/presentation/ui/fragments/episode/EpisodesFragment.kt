package com.timplifier.rickandmorty.presentation.ui.fragments.episode

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.databinding.FragmentEpisodesBinding


class EpisodesFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {
    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()


}