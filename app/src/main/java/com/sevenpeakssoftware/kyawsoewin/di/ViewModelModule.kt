package com.sevenpeakssoftware.kyawsoewin.di

import com.sevenpeakssoftware.kyawsoewin.data.cache.impl.getcar.GetCarListImpl
import com.sevenpeakssoftware.kyawsoewin.data.cache.impl.getcar.GetCarListRepo
import com.sevenpeakssoftware.kyawsoewin.data.cache.impl.insertcar.InsertCarListImpl
import com.sevenpeakssoftware.kyawsoewin.data.cache.impl.insertcar.InsertCarListRepo
import com.sevenpeakssoftware.kyawsoewin.data.remote.impl.fetchcarlist.FetchCarImpl
import com.sevenpeakssoftware.kyawsoewin.domain.remote.fetchcarlist.FetchCarListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    @ViewModelScoped
    abstract fun bindFetchCarImpl(fetchCarImpl: FetchCarImpl): FetchCarListRepo

    @Binds
    @ViewModelScoped
    abstract fun bindInsertCarListImpl(insertCarListImpl: InsertCarListImpl): InsertCarListRepo

    @Binds
    @ViewModelScoped
    abstract fun bindGetCarListImpl(insertCarListImpl: GetCarListImpl): GetCarListRepo
}