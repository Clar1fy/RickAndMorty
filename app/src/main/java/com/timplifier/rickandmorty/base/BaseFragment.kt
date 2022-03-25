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
        initialize()
        setupViews()
        setupListeners()
        setupObserver()
        setupRequest()
    }

    protected open fun initialize() {


    }

    protected open fun setupViews() {


    }

    protected open fun setupListeners() {
    }


    protected open fun setupObserver() {

    }

    protected open fun setupRequest() {

    }
}