package com.quoders.apps.madridbus.ui.stopInfo

import com.quoders.apps.madridbus.domain.interactors.stopInfo.StopInfoInteractor
import com.quoders.apps.madridbus.model.arrivals.Arrivals
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class StopInfoPresenter @Inject
constructor(private val mView: StopInfoContract.View, private val mInteractor: StopInfoInteractor) : StopInfoContract.Presenter {

    private val mDisposables = CompositeDisposable()

    override fun start() {
        mView.showProgressBar()

        val observer = object : DisposableObserver<Arrivals>() {
            override fun onNext(arrivals: Arrivals?) {
                if(arrivals != null && arrivals.arrives != null && !arrivals.arrives.isEmpty()) {
                    mView.displayArrivals(arrivals)
                }
            }

            override fun onError(e: Throwable?) {
                mView.showErrorGettingArrivals()
                mView.dismissProgressBar()
            }

            override fun onComplete() {
                mView.dismissProgressBar()
            }
        }

        mDisposables.add(observer)

        mInteractor.execute(observer)
    }

    override fun stop() {
        mDisposables.clear()
    }

}
