package com.sevenpeakssoftware.kyawsoewin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist.CarListVO
import com.sevenpeakssoftware.kyawsoewin.domain.usecase.fetchcarimpl.FetchCarListUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GetCarListViewModel @Inject constructor(
    private val fetchCarListUseCaseImpl: FetchCarListUseCaseImpl,
) : BaseViewModel() {
    val carListLiveData: MutableLiveData<ViewState<CarListVO>> by lazy {
        MutableLiveData()
    }

    init {
        getCarList()
    }

    private fun getCarList() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchCarListUseCaseImpl.getCarList().collect {
                carListLiveData.postValue(it)
            }
        }
    }
}