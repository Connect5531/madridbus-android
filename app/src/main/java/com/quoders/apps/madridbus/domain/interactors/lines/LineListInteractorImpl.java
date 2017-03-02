package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.lines.LinesLocalRepository;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.LineMapper;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import java.util.List;
import java.util.concurrent.Callable;

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
    public Observable<List<LineBase>> getLinesList(String date) {

        return Observable.fromCallable(new Callable<List<LineBase>>() {
            @Override
            public List<LineBase> call() throws Exception {
                return mLinesRepository.query();
            }
        });
    }

    @Override
    public void saveLinesList(List<LineBase> lines) {
        mLinesRepository.add(lines);
    }
}
