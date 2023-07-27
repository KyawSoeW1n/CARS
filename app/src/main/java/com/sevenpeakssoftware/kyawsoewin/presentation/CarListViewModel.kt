package com.sevenpeakssoftware.kyawsoewin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sevenpeakssoftware.kyawsoewin.data.cache.impl.getcar.GetCarListImpl
import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarItemVO
import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarListVO
import com.sevenpeakssoftware.kyawsoewin.domain.usecase.fetchcarimpl.FetchCarListUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
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
            fetchCarListUseCaseImpl.getCarList().collectLatest {
                carListLiveData.postValue(it)
            }
        }
    }
}