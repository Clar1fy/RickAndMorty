package com.timplifier.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timplifier.rickandmorty.databinding.PagingLoadStateFooterBinding

class PagingLoadStateAdapter : LoadStateAdapter<PagingLoadStateAdapter.LoadStateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            PagingLoadStateFooterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.onBind(loadState)
    }

    inner class LoadStateViewHolder(private val binding: PagingLoadStateFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(loadState: LoadState) {


            binding.progressBar.isVisible = loadState is LoadState.Loading
        }

    }
}
