package com.quoders.apps.madridbus.domain.repository.routes;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.CloudRepository;
import com.quoders.apps.madridbus.domain.utils.DateUtils;
import com.quoders.apps.madridbus.model.routes.RouteInfoEmt;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class RouteCloudRepository implements CloudRepository<RouteInfoEmt> {

    private EmtRestApi mEmtRestApi;
    private String mLineCode;

    @Inject
    public RouteCloudRepository(EmtRestApi emtRestApi, String lineCode) {
        mEmtRestApi = emtRestApi;
        mLineCode = lineCode;
    }

    @Override
    public Observable<RouteInfoEmt> query() {
        return mEmtRestApi.getLineRoute("WEB.SERV.david.guerrero@quoders.com",
                "AF04314A-2997-420E-A190-823D7EBA12DE", DateUtils.getTodayShortFormat(), mLineCode)
                .onErrorReturnItem(new RouteInfoEmt())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }
}
