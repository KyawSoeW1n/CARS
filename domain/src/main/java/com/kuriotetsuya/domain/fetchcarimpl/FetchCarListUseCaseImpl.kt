package com.kuriotetsuya.domain.fetchcarimpl

import com.kuriotetsuya.domain.UseCaseState
import com.kuriotetsuya.domain.model.fetchcarlist.CarListVO
import com.kuriotetsuya.domain.remote.fetchcarlist.FetchCarListRepo
import com.sevenpeakssoftware.kyawsoewin.data.cache.insertcar.InsertCarListImpl
import com.sevenpeakssoftware.kyawsoewin.extensions.isOnline
import com.sevenpeakssoftware.kyawsoewin.mapper.CarListMapper
import com.sevenpeakssoftware.kyawsoewin.network.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchCarListUseCaseImpl @Inject constructor(
    private val FetchCarListRepo: FetchCarListRepo,
    private val carListMapper: CarListMapper,
    private val insertCarListImpl: InsertCarListImpl,
) : FetchCarListUseCase {
    override fun getCarList(): Flow<com.kuriotetsuya.presentation.ViewState<CarListVO>> =
        flow {
            emit(com.kuriotetsuya.presentation.ViewState.Loading)
            if (context.isOnline()) {
                val response = safeApiCall {
                    FetchCarListRepo.getCarList()
                }

                when (response) {
                    is UseCaseState.Success -> {
                        response.successData?.let { data ->
                            if (data.status == "success") {
                                val mapResponse = carListMapper.mapFromResponse(data)
                                insertCarListImpl.insertCarList(mapResponse.carList)
                                emit(com.kuriotetsuya.presentation.ViewState.Success(mapResponse))
                            } else {
                                emit(com.kuriotetsuya.presentation.ViewState.Error("Error"))
                            }
                        } ?: run {
                            emit(com.kuriotetsuya.presentation.ViewState.Error("Error"))
                        }
                    }
                    is UseCaseState.Error -> emit(
                        com.kuriotetsuya.presentation.ViewState.Error(
                            response.message
                        )
                    )
                    is UseCaseState.ResourceNotFound -> emit(com.kuriotetsuya.presentation.ViewState.ResourceNotFound)
                    is UseCaseState.ServerError -> emit(com.kuriotetsuya.presentation.ViewState.ServerError)
                    is UseCaseState.NetworkError -> emit(com.kuriotetsuya.presentation.ViewState.NetworkError)
                    is UseCaseState.Unauthorized -> emit(
                        com.kuriotetsuya.presentation.ViewState.Unauthorized(
                            response.message
                        )
                    )
                    else -> emit(com.kuriotetsuya.presentation.ViewState.ResourceNotFound)
                }
            } else {
                emit(com.kuriotetsuya.presentation.ViewState.NetworkError)
            }
        }
}