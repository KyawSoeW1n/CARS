package com.sevenpeakssoftware.kyawsoewin.domain.usecase.fetchcarimpl

import android.content.Context
import com.sevenpeakssoftware.kyawsoewin.data.mapper.CarListMapper
import com.sevenpeakssoftware.kyawsoewin.data.model.fetchcarlist.CarListVO
import com.sevenpeakssoftware.kyawsoewin.domain.remote.fetchcarlist.FetchCarListRepo
import com.sevenpeakssoftware.kyawsoewin.domain.usecase.UseCaseState
import com.sevenpeakssoftware.kyawsoewin.network.safeApiCall
import com.sevenpeakssoftware.kyawsoewin.presentation.ViewState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchCarListUseCaseImpl @Inject constructor(
    private val FetchCarListRepo: FetchCarListRepo,
    private val carListMapper: CarListMapper,
    @ApplicationContext private val context: Context,
) : FetchCarListUseCase {
    override fun getCarList(): Flow<ViewState<CarListVO>> =
        flow {
            emit(ViewState.Loading)
            val response = safeApiCall {
                FetchCarListRepo.getCarList()
            }

            when (response) {
                is UseCaseState.Success -> {
                    response.successData?.let { response ->
                        if (response.status == "success") {
                            emit(
                                ViewState.Success(
                                    carListMapper.mapFromResponse(response)
                                )
                            )
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
        }
}