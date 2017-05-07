package com.quoders.apps.madridbus.domain.repository.lines;


import com.quoders.apps.madridbus.domain.repository.Cache;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.lines.ListLineInfoEmt;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

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
    public Observable<Iterable<LineBase>> getLinesList() {
        if (mCache.isDataOutdated("")) {
            return getCloudLineListObservable();
        } else {
            return getLocalLineListObservable();
        }
    }

    private Observable<Iterable<LineBase>> getLocalLineListObservable() {
        return mLocalRepository.queryItems();
    }

    private Observable<Iterable<LineBase>> getCloudLineListObservable() {
        return mCloudRepository.query().map(new Function<ListLineInfoEmt, Iterable<LineBase>>() {
            @Override
            public Iterable<LineBase> apply(ListLineInfoEmt listLineInfoEmt) throws Exception {
                List<LineBase> mapped = LinesRepositoryMapper.map(listLineInfoEmt);
                if(mapped != null && !mapped.isEmpty()) {
                    mCache.setCache("");
                    mLocalRepository.add(mapped);
                }
                return mapped;
            }
        });
    }

    @Override
    public void releaseRepository() {
        mLocalRepository.close();
    }
}
