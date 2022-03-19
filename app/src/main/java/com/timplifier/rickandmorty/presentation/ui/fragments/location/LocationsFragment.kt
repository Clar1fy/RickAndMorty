package com.timplifier.rickandmorty.presentation.ui.fragments.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.rickandmorty.R
import com.timplifier.rickandmorty.base.BaseFragment
import com.timplifier.rickandmorty.databinding.FragmentLocationsBinding


class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationViewModel >(
    R.layout.fragment_locations
) {
    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationsBinding::bind)
}