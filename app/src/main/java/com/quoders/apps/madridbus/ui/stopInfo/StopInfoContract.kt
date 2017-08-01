package com.quoders.apps.madridbus.ui.stopInfo

import com.quoders.apps.madridbus.BasePresenter
import com.quoders.apps.madridbus.BaseView
import com.quoders.apps.madridbus.model.arrivals.Arrivals

interface StopInfoContract {

    interface View : BaseView<Presenter> {

        fun showProgressBar()

        fun dismissProgressBar()

        fun showErrorGettingArrivals()

        fun  displayArrivals(arrivals: Arrivals)
    }

    interface Presenter : BasePresenter
}
