package com.bookmyshow.assignment.di

import android.content.Context
import com.bookmyshow.assignment.MainActivity
import com.bookmyshow.common_ui.di.CommonModule
import com.bookmyshow.core.di.CoreComponent
import com.bookmyshow.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}