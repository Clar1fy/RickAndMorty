package com.timplifier.rickandmorty.common.extensions

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


fun <T> ListAdapter<ListAdapter, RecyclerView.ViewHolder>.setList(
    newList: List<T>,
    currentList: List<T>
) {
    var list: List<T> = ArrayList()

    this.list = list

}