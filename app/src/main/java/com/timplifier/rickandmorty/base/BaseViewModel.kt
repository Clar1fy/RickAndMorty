package com.timplifier.rickandmorty.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timplifier.rickandmorty.common.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.subscribe(
        state: MutableLiveData<T>,
        requestRoom: suspend (data: T?) -> Unit,
        addition: () -> Unit
    ) {
        viewModelScope.launch {
            collect {
                when (it) {
                    is Resource.Loading -> {

                    }
                    is Resource.Error -> {
                        Log.e("gaypop", it.message.toString())
                    }
                    is Resource.Success -> {
                        requestRoom(it.data)
                        addition
                        state.postValue(
                            it.data
                        )
                    }
                }
            }
        }
    }


}
