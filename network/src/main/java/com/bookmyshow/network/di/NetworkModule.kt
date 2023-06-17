package com.bookmyshow.network.di

import android.content.Context
import com.bookmyshow.core.NetworkManager
import com.bookmyshow.core.NetworkProvider
import com.bookmyshow.network.manager.NetworkManagerImpl
import com.bookmyshow.network.provider.NetworkProviderImpl
import dagger.Module
import dagger.Provides

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
}