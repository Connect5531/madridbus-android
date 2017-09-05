package com.quoders.apps.madridbus.domain.interactors.stopInfo

import com.quoders.apps.madridbus.BaseInteractor
import com.quoders.apps.madridbus.domain.network.EmtRestApi
import com.quoders.apps.madridbus.model.arrivals.Arrivals
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class StopInfoInteractor @Inject
constructor(val stopCode: String, val emtRestApi: EmtRestApi) : BaseInteractor() {

    override fun release() {
    }

    override fun buildInteractorObservable(): Observable<Arrivals> {

        return emtRestApi.getStopArrivals("WEB.SERV.david.guerrero@quoders.com",
                "AF04314A-2997-420E-A190-823D7EBA12DE", stopCode,"EN")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }
}
