package com.quoders.apps.madridbus.domain.repository.routes;


import com.quoders.apps.madridbus.domain.repository.Cache;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryMapper;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.model.routes.RouteInfoEmt;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class RouteRepositoryImpl implements RouteRepository {

    private Cache mCache;
    private RouteCloudRepository mCloudRepository;
    private RouteLocalRepository mLocalRepository;
    private String mCode;

    @Inject
    public RouteRepositoryImpl(Cache cache,
                               RouteCloudRepository cloudRepository,
                               RouteLocalRepository localRepository) {
        this.mCache = cache;
        this.mCloudRepository = cloudRepository;
        this.mLocalRepository = localRepository;
    }

    @Override
    public Observable<Iterable<StopBase>> getRoute(String code) {
        mCode = code;
        if (mCache.isDataOutdated(code)) {
            return getCloudRouteObservable();
        } else {
            return getLocalRouteObservable();
        }
    }

    private Observable<Iterable<StopBase>> getLocalRouteObservable() {
        return mLocalRepository.queryItems(mCode);
    }

    private Observable<Iterable<StopBase>> getCloudRouteObservable() {
        return mCloudRepository.query().map(new Function<RouteInfoEmt, Iterable<StopBase>>() {
            @Override
            public Iterable<StopBase> apply(RouteInfoEmt routeInfoEmt) throws Exception {
                List<StopBase> mapped = RouteRepositoryMapper.map(routeInfoEmt);
                if(mapped != null && !mapped.isEmpty()) {
                    mCache.setCache(mCode);
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
