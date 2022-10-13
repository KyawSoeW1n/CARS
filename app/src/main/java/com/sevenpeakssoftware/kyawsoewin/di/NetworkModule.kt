package com.myanthai.agent.di

import android.content.Context
import com.myanthai.agent.BuildConfig
import com.sevenpeakssoftware.kyawsoewin.network.ApiService
import com.myanthai.agent.network.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MY_PROJECT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit.Builder): ApiService {
        return retrofit.build().create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTokenInterceptor(
        @ApplicationContext context: Context
    ) =
        TokenInterceptor(context = context)

    @Provides
    @Singleton
    fun providesLoggingInterceptor(tokenInterceptor: TokenInterceptor): OkHttpClient {
        val httpInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            httpInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        return OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .addInterceptor(tokenInterceptor)
            .build()
    }
}