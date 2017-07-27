package com.quoders.apps.madridbus.ui.stopInfo

import dagger.Module
import dagger.Provides

@Module
class StopInfoPresenterModule(private val mView: StopInfoContract.View) {

    @Provides
    internal fun provideStopInfoContractView(): StopInfoContract.View {
        return mView
    }
}
