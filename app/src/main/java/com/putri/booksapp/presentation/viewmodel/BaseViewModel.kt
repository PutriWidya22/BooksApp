package com.putri.booksapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.putri.booksapp.data.error.Failure

// membuat class abstract dengan nama BaseViewModel dengan mengextends ViewModel
abstract class BaseViewModel : ViewModel() {

    // deklarasi variabel failure dengan LiveData
    private val failure: MutableLiveData<Failure> = MutableLiveData()

    fun observeFailure(): LiveData<Failure> = failure

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }

    override fun onCleared() {
        super.onCleared()
        cancelRequest()
    }

    abstract fun cancelRequest()
}