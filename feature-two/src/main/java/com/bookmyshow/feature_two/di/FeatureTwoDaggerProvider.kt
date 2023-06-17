package com.bookmyshow.feature_two.di

import com.bookmyshow.core.di.CoreComponentProvider

object FeatureTwoDaggerProvider {

    val component: FeatureTwoComponent by lazy {
        DaggerFeatureTwoComponent.factory().create(
            coreComponent = CoreComponentProvider.coreComponent
        )
    }
}