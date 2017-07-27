package com.quoders.apps.madridbus.ui.stopInfo

import com.quoders.apps.madridbus.domain.interactors.route.RouteInteractor
import com.quoders.apps.madridbus.model.StopBase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class StopInfoPresenter @Inject
constructor(private val mView: StopInfoContract.View, private val mInteractor: RouteInteractor) : StopInfoContract.Presenter {

    override fun onViewStart(stopId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val mDisposables = CompositeDisposable()

    override fun start() {
        mView.showProgressBar()

        val observer = object : DisposableObserver<List<StopBase>>() {
            override fun onNext(stops: List<StopBase>?) {
                if (stops != null && stops.iterator().hasNext()) {
                    //mView.displayRoute(stops)
                } else {
                    onError(null)
                }
            }

            override fun onError(e: Throwable?) {
                //mView.showErrorLoadingList()
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
