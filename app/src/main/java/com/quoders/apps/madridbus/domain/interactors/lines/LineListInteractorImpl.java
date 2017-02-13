package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.lines.LinesLocalRepository;
import com.quoders.apps.madridbus.model.LineMapper;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LineListInteractorImpl implements LinesListInteractor {

    private EmtRestApi mEmtRestApi;
    private LinesLocalRepository mLinesRepository;

    @Inject
    public LineListInteractorImpl(EmtRestApi mEmtRestApi, LinesLocalRepository linesRepository) {
        this.mEmtRestApi = mEmtRestApi;
        this.mLinesRepository = linesRepository;
    }

    @Override
    public Observable<ListLineInfoEmt> getLinesList(String date) {
        return mEmtRestApi.getListLines("WEB.SERV.david.guerrero@quoders.com",
                "AF04314A-2997-420E-A190-823D7EBA12DE", date)
                .onErrorReturnItem(new ListLineInfoEmt())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }

    @Override
    public void saveLinesList(ListLineInfoEmt lines) {
        mLinesRepository.add(LineMapper.MAP(lines.getResultValues().get(0)));
        //mLinesRepository.add(LineMapper.MAP(lines));
    }


}
