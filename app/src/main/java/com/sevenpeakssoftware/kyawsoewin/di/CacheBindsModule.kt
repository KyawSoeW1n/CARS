package com.sevenpeakssoftware.kyawsoewin.di

import com.sevenpeakssoftware.kyawsoewin.data.cache.getcar.GetCarListImpl
import com.sevenpeakssoftware.kyawsoewin.data.cache.getcar.GetCarListRepo
import com.sevenpeakssoftware.kyawsoewin.data.cache.insertcar.InsertCarListImpl
import com.sevenpeakssoftware.kyawsoewin.data.cache.insertcar.InsertCarListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class CacheBindsModule {
    @Binds
    @ViewModelScoped
    abstract fun bindInsertCarListImpl(insertCarListImpl: InsertCarListImpl): InsertCarListRepo

    @Binds
    @ViewModelScoped
    abstract fun bindGetCarListImpl(insertCarListImpl: GetCarListImpl): GetCarListRepo
}