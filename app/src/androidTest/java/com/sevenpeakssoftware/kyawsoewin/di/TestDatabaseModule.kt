package com.sevenpeakssoftware.kyawsoewin.di

import android.content.Context
import androidx.room.Room
import com.sevenpeakssoftware.kyawsoewin.data.cache.CarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.testing.TestInstallIn

@TestInstallIn(components = [SingletonComponent::class], replaces = [CacheModule::class])
@Module
class TestDatabaseModule {

    @Singleton
    @Provides
    fun provideTestDB(@ApplicationContext context: Context): CarDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            CarDatabase::class.java
        ).allowMainThreadQueries().build()
    }
}