package com.sevenpeakssoftware.kyawsoewin.di

import android.content.Context
import androidx.room.Room
import com.sevenpeakssoftware.kyawsoewin.cache.CarDatabase
import com.sevenpeakssoftware.kyawsoewin.cache.DatabaseConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [CacheModule::class])
class TestDatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        CarDatabase::class.java,
        DatabaseConstants.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideYourDao(db: CarDatabase) = db.getCarDao()
}