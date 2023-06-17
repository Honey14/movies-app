package com.bookmyshow.feature_two.di

import com.bookmyshow.core.di.CoreComponent
import com.bookmyshow.feature_two.FeatureTwoActivity
import dagger.Component

@Component(
    dependencies = [
        CoreComponent::class
    ]
)
interface FeatureTwoComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): FeatureTwoComponent
    }

    fun inject(activity: FeatureTwoActivity)
}