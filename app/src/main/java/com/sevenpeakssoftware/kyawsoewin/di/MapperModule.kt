package com.sevenpeakssoftware.kyawsoewin.di

import com.sevenpeakssoftware.kyawsoewin.data.remote.mapper.CarListMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MapperModule {
    @Provides
    @ViewModelScoped
    fun provideCarListMapper() = CarListMapper()
}