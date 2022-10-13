package com.myanthai.agent.network

import android.content.Context
import com.myanthai.agent.BuildConfig
import com.myanthai.agent.core.DATASTORE_TOKEN
import com.myanthai.agent.extension.getStringData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val context: Context,
) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("version", getVersionName())
            .build()
        val requestBuilder = original.newBuilder().url(url = url)
        requestBuilder.addHeader("Authorization", "Bearer ${getToken()}")


        return chain.proceed(requestBuilder.build())
    }

    private fun getToken(): String {
        var token = ""
        runBlocking {
            context.getStringData(DATASTORE_TOKEN).first()?.let {
                if (it.isNotEmpty()) {
                    token = it
                }
                return@let token
            } ?: run {
                return@run token
            }
        }
        return token
    }


    private fun getVersionName(): String {
        return if (BuildConfig.DEBUG) {
            "1.0.0"
        } else {
            BuildConfig.VERSION_NAME
        }
    }
}