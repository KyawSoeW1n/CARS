package com.sevenpeakssoftware.kyawsoewin.domain.usecase.fetchcarimpl

import android.content.Context
import com.sevenpeakssoftware.kyawsoewin.data.cache.impl.insertcar.InsertCarListImpl
import com.sevenpeakssoftware.kyawsoewin.data.remote.mapper.CarListMapper
import com.sevenpeakssoftware.kyawsoewin.data.remote.model.fetchcarlist.CarListVO
import com.sevenpeakssoftware.kyawsoewin.domain.remote.fetchcarlist.FetchCarListRepo
import com.sevenpeakssoftware.kyawsoewin.domain.usecase.UseCaseState
import com.sevenpeakssoftware.kyawsoewin.extensions.isOnline
import com.sevenpeakssoftware.kyawsoewin.network.safeApiCall
import com.sevenpeakssoftware.kyawsoewin.presentation.ViewState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchCarListUseCaseImpl @Inject constructor(
    private val FetchCarListRepo: FetchCarListRepo,
    private val carListMapper: CarListMapper,
    private val insertCarListImpl: InsertCarListImpl,
    @ApplicationContext private val context: Context,
) : FetchCarListUseCase {
    override fun getCarList(): Flow<ViewState<CarListVO>> =
        flow {
            emit(ViewState.Loading)
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
                                emit(ViewState.Success(mapResponse))
                            } else {
                                emit(ViewState.Error("Error"))
                            }
                        } ?: run {
                            emit(ViewState.Error("Error"))
                        }
                    }
                    is UseCaseState.Error -> emit(ViewState.Error(response.message))
                    is UseCaseState.ResourceNotFound -> emit(ViewState.ResourceNotFound)
                    is UseCaseState.ServerError -> emit(ViewState.ServerError)
                    is UseCaseState.NetworkError -> emit(ViewState.NetworkError)
                    is UseCaseState.Unauthorized -> emit(ViewState.Unauthorized(response.message))
                    else -> emit(ViewState.ResourceNotFound)
                }
            } else {
                emit(ViewState.NetworkError)
            }
        }
}