package com.quoders.apps.madridbus.ui.stopInfo


import com.quoders.apps.madridbus.ApplicationComponent
import com.quoders.apps.madridbus.di.FragmentScoped

import dagger.Component

@FragmentScoped
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(StopInfoPresenterModule::class))
interface StopInfoComponent {

    fun inject(stopInfoActivity: StopInfoActivity)
}
