package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LineListInteractorImpl implements LinesListInteractor {

    private EmtRestApi mEmtRestApi;

    @Inject
    public LineListInteractorImpl(EmtRestApi mEmtRestApi) {
        this.mEmtRestApi = mEmtRestApi;
    }

    @Override
    public Observable<ListLineInfoEmt> getLinesList(String date) {
        return mEmtRestApi.getListLines("WEB.SERV.david.guerrero@quoders.com",
                "AF04314A-2997-420E-A190-823D7EBA12DE", date)
                .onErrorReturnItem(new ListLineInfoEmt())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }
}
