package com.bookmyshow.core.di

import android.content.Context
import com.bookmyshow.core.ImageLoader
import com.bookmyshow.core.NetworkManager
import com.bookmyshow.core.NetworkProvider
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreComponent {

//    fun getContext(): Context

    fun getImageLoader(): ImageLoader

    fun getNetworkProvider(): NetworkProvider

    fun getNetworkManager(): NetworkManager
}