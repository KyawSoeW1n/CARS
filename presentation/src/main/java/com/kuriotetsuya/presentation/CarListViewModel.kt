package com.kuriotetsuya.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kuriotetsuya.domain.fetchcarimpl.FetchCarListUseCaseImpl
import com.kuriotetsuya.domain.model.fetchcarlist.CarItemVO
import com.kuriotetsuya.domain.model.fetchcarlist.CarListVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarListViewModel @Inject constructor(
    private val fetchCarListUseCaseImpl: FetchCarListUseCaseImpl,
    private val getCarListImpl: GetCarListImpl
) : BaseViewModel() {
    val carListLiveData: MutableLiveData<ViewState<CarListVO>> by lazy {
        MutableLiveData()
    }

    val cacheCarListLiveData: MutableLiveData<MutableList<CarItemVO>> by lazy {
        MutableLiveData()
    }

    init {
        fetchCarList()

    }

    fun getCacheList() {
        viewModelScope.launch(Dispatchers.IO) {

            cacheCarListLiveData.postValue(getCarListImpl.getCarList())
        }
    }

    private fun fetchCarList() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchCarListUseCaseImpl.getCarList().collect {
                carListLiveData.postValue(it)
            }
        }
    }
}