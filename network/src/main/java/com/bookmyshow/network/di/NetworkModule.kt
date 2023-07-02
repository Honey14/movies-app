package com.bookmyshow.network.di

import android.content.Context
import com.bookmyshow.core.NetworkManager
import com.bookmyshow.core.NetworkProvider
import com.bookmyshow.network.manager.NetworkManagerImpl
import com.bookmyshow.network.provider.NetworkProviderImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun getNetworkManager(
        context: Context
    ): NetworkManager {
        return NetworkManagerImpl(
            context = context
        )
    }

    @Provides
    fun getNetworkProvider(): NetworkProvider {
        return NetworkProviderImpl()
    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().build()
}
