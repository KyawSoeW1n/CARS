package com.sevenpeakssoftware.kyawsoewin.di

import android.content.Context
import androidx.room.Room
import com.sevenpeakssoftware.kyawsoewin.data.cache.CarDatabase
import com.sevenpeakssoftware.kyawsoewin.data.cache.DatabaseConstants
import com.sevenpeakssoftware.kyawsoewin.data.cache.dao.CarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        CarDatabase::class.java,
        DatabaseConstants.DB_NAME
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: CarDatabase) = db.carDao()
}