package com.quoders.apps.madridbus.domain.interactors.stopInfo

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.quoders.apps.madridbus.BaseInteractor
import com.quoders.apps.madridbus.domain.network.EmtRestApi
import com.quoders.apps.madridbus.domain.network.EmtRestDefs
import com.quoders.apps.madridbus.domain.utils.DateUtils
import com.quoders.apps.madridbus.model.LineBase
import com.quoders.apps.madridbus.model.StopBase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class StopInfoInteractor @Inject
constructor(private val stopCode: String) : BaseInteractor() {

    override fun release() {

    }
    override fun buildInteractorObservable(): Observable<Any> {

        val retrofit = Retrofit.Builder()
                .baseUrl(EmtRestDefs.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val emtRestApi = retrofit.create(EmtRestApi::class.java)

        return emtRestApi.getStopArrivals("WEB.SERV.david.guerrero@quoders.com",
                "AF04314A-2997-420E-A190-823D7EBA12DE", stopCode,"EN")
                .onErrorReturnItem(null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }
}
