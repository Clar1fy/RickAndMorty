package com.timplifier.rickandmorty.presentation.ui.fragments.location

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.common.extensions.isInternetConnectionAvailable
import com.timplifier.rickandmorty.common.extensions.submitData
import com.timplifier.rickandmorty.databinding.FragmentLocationsBinding
import com.timplifier.rickandmorty.presentation.ui.adapters.LocationsAdapter
import com.timplifier.rickandmorty.utils.PaginationScrollListener
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationViewModel>(
    R.layout.fragment_locations
) {
    override val viewModel: LocationViewModel by viewModel()
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    private val locationsAdapter = LocationsAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.apply {
            adapter = locationsAdapter
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addOnScrollListener(object :
                PaginationScrollListener(
                    linearLayoutManager,
                    { if (requireContext().isInternetConnectionAvailable(requireContext())) viewModel.fetchLocations() }) {

                override fun isLoading() = viewModel.isLoading
            })

        }
    }

    override fun setupObserver() {
        gatherToLocations()
        gatherToLocalLocations()
    }

    private fun gatherToLocalLocations() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.localLocationState.observe(viewLifecycleOwner) {
                locationsAdapter.submitData(it)
            }
        }
    }

    private fun gatherToLocations() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.locationState.observe(viewLifecycleOwner) {
                locationsAdapter.submitData(it.results)
            }
        }
    }

    override fun setupRequest() {

        if (viewModel.locationState.value == null && requireContext().isInternetConnectionAvailable(
                requireContext()
            )
        ) {

            Log.e("GayPop", "Internet is available ")
            viewModel.fetchLocations()

        } else viewModel.getLocations()
    }
}