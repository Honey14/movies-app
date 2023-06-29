package com.bookmyshow.common_ui.di

import android.content.Context
import com.bookmyshow.common_ui.imageloader.ImageLoaderImpl
import com.bookmyshow.core.ImageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Provides
    fun getImageLoader(
        @ApplicationContext context: Context
    ): ImageLoader {
        return ImageLoaderImpl(
            context = context
        )
    }
}