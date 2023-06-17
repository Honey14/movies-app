package com.bookmyshow.core

interface NetworkProvider {

    fun <T : Any> getApi(
        apiClass: Class<T>,
        baseUrl: String
    ): T
}