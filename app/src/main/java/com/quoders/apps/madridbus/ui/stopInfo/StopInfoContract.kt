package com.quoders.apps.madridbus.ui.stopInfo

import com.quoders.apps.madridbus.BasePresenter
import com.quoders.apps.madridbus.BaseView

interface StopInfoContract {

    interface View : BaseView<Presenter> {

        fun showProgressBar()

        fun dismissProgressBar()

        fun showErrorLoadingInfo()
    }

    interface Presenter : BasePresenter {
        fun onViewStart(stopId: String)
    }
}
