package com.sevenpeakssoftware.kyawsoewin.di

import android.content.Context
import androidx.room.Room
import com.sevenpeakssoftware.kyawsoewin.data.cache.CarDatabase
import com.sevenpeakssoftware.kyawsoewin.data.cache.DatabaseConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.testing.TestInstallIn
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