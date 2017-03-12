package com.quoders.apps.madridbus.domain.repository.lines;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.domain.utils.DateUtils;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class LinesCloudRepository implements Repository<ListLineInfoEmt> {

    private EmtRestApi mEmtRestApi;

    @Inject
    public LinesCloudRepository(EmtRestApi emtRestApi) {
        mEmtRestApi = emtRestApi;
    }

    @Override
    public void add(Iterable items) {
    }

    @Override
    public void add(ListLineInfoEmt item) {
    }

    @Override
    public void update(ListLineInfoEmt item) {
    }

    @Override
    public void remove(ListLineInfoEmt item) {
    }

    @Override
    public Observable<ListLineInfoEmt> query() {
        return mEmtRestApi.getListLines("WEB.SERV.david.guerrero@quoders.com",
                "AF04314A-2997-420E-A190-823D7EBA12DE", DateUtils.getTodayShortFormat())
                .onErrorReturnItem(new ListLineInfoEmt())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }

    @Override
    public Observable<Iterable<ListLineInfoEmt>> queryItems() {
        return null;
    }
}
