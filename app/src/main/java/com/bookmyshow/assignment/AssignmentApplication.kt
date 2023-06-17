package com.bookmyshow.assignment

import android.app.Application
import com.bookmyshow.assignment.di.AppComponent
import com.bookmyshow.assignment.di.DaggerAppComponent
import com.bookmyshow.assignment.di.DaggerAppComponentProvider
import com.bookmyshow.core.di.CoreComponentProvider

class AssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
        DaggerAppComponentProvider.setAppComponent(appComponent)
        CoreComponentProvider.coreComponent = appComponent
    }
}