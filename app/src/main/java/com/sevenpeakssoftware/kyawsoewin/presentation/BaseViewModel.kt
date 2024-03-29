package com.sevenpeakssoftware.kyawsoewin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}