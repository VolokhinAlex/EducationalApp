package com.volokhinaleksey.educationalapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel<T> : ViewModel() {

    protected val _data: MutableLiveData<T> = MutableLiveData()
    val data: LiveData<T> get() = _data

    protected val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     */

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}