package com.kuriotetsuya.domain.fetchcarimpl

import com.kuriotetsuya.domain.model.fetchcarlist.CarListVO
import kotlinx.coroutines.flow.Flow


interface FetchCarListUseCase {
    fun getCarList(): Flow<ViewState<CarListVO>>
}