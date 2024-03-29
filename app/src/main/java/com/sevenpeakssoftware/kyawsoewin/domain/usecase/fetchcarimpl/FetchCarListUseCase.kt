package com.sevenpeakssoftware.kyawsoewin.domain.usecase.fetchcarimpl

import com.sevenpeakssoftware.kyawsoewin.domain.model.CarListVO
import com.sevenpeakssoftware.kyawsoewin.presentation.ViewState
import kotlinx.coroutines.flow.Flow


interface FetchCarListUseCase {
    fun getCarList(): Flow<ViewState<CarListVO>>
}