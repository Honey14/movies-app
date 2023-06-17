package com.bookmyshow.common_ui.di

import android.content.Context
import com.bookmyshow.common_ui.imageloader.ImageLoaderImpl
import com.bookmyshow.core.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    fun getImageLoader(
        context: Context
    ): ImageLoader {
        return ImageLoaderImpl(
            context = context
        )
    }
}