package com.bookmyshow.common_ui.di

import dagger.Component

@Component(
    modules = [
        CommonModule::class
    ]
)
interface CommonComponent {

    @Component.Factory
    interface Factory {
        fun create(): CommonComponent
    }
}