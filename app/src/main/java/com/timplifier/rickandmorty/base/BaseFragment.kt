package com.timplifier.rickandmorty.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding, ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupViews()
        setupObserver()
        setupRequest()
        initialize()
    }

    open fun setupListeners() {
    }


    open fun initialize() {

    }

    open fun setupViews() {

    }

    open fun setupRequest() {

    }

    open fun setupObserver() {

    }
}