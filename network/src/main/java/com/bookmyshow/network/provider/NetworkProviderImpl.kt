package com.bookmyshow.network.provider

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal class NetworkProviderImpl : com.bookmyshow.core.NetworkProvider {

    private companion object {
        const val CONNECT_TIMEOUT = 30L
        const val READ_TIMEOUT = 30L
    }

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()

    override fun <ApiClass : Any> getApi(
        apiClass: Class<ApiClass>,
        baseUrl: String,
        moshi: Moshi
    ): ApiClass {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            )
            .build()
            .create(apiClass) as ApiClass
    }
}