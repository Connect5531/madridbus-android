package com.quoders.apps.madridbus.domain.repository.lines;


import com.quoders.apps.madridbus.domain.repository.Cache;
import com.quoders.apps.madridbus.model.LineBase;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LinesRepositoryImpl implements LinesRepository {

    private Cache mCache;
    LinesCloudRepository mCloudRepository;
    LinesLocalRepository mLocalRepository;

    @Inject
    public LinesRepositoryImpl(Cache cache,
                               LinesCloudRepository cloudRepository,
                               LinesLocalRepository linesLocalRepository) {
        this.mCache = cache;
        this.mCloudRepository = cloudRepository;
        this.mLocalRepository = linesLocalRepository;
    }

    @Override
    public Observable<List<LineBase>> getLinesList() {
        if (mCache.isDataOutdated()) {
            return getCloudLineListObservable();
        } else {
            return getLocalLineListObservable();
        }
    }

    private Observable<List<LineBase>> getLocalLineListObservable() {
        return Observable.fromCallable(new Callable<List<LineBase>>() {
            @Override
            public List<LineBase> call() throws Exception {
                return mLocalRepository.query();
            }
        });
    }

    private Observable<List<LineBase>> getCloudLineListObservable() {
        return Observable.fromCallable(new Callable<List<LineBase>>() {
            @Override
            public List<LineBase> call() throws Exception {
                return mCloudRepository.query();
            }
        });
    }
}
