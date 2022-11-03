package com.sevenpeakssoftware.kyawsoewin.di

import com.sevenpeakssoftware.kyawsoewin.data.remote.fetchcarlist.FetchCarImpl
import com.kuriotetsuya.domain.remote.fetchcarlist.FetchCarListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteBindsModule {
    @Binds
    @ViewModelScoped
    abstract fun bindFetchCarImpl(fetchCarImpl: FetchCarImpl): FetchCarListRepo
}