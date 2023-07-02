package com.bookmyshow.core

import com.squareup.moshi.Moshi

interface NetworkProvider {

    fun <T : Any> getApi(
        apiClass: Class<T>,
        baseUrl: String,
        moshi: Moshi
    ): T
}