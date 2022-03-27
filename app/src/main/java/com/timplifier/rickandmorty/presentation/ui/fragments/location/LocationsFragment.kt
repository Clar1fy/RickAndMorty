package com.timplifier.rickandmorty.presentation.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.databinding.FragmentLocationsBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.LocationsAdapter
import com.timplifier.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationViewModel>(
    R.layout.fragment_locations
) {
    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    private val adapter = LocationsAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {


        binding.recyclerview.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            adapter = adapter
            addOnScrollListener(object :
                PaginationScrollListener(linearLayoutManager, { viewModel.fetchLocations() }) {

                override fun isLoading() = viewModel.isLoading
            })
        }
    }

    override fun setupObserver() {
        subscribeToLocations()
    }

    private fun subscribeToLocations() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchLocations().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}