package com.timplifier.rickandmorty.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    fun <T> subscribeTo(fetch: suspend () -> Unit) {


    }


}
