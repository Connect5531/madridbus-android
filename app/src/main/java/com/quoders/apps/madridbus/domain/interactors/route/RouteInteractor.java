package com.quoders.apps.madridbus.domain.interactors.route;

import com.quoders.apps.madridbus.BaseInteractor;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.domain.repository.routes.RouteRepository;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RouteInteractor extends BaseInteractor {

    private RouteRepository mRouteRepository;
    private String mCode;

    @Inject
    public RouteInteractor(RouteRepository routesRepository, String code) {
        this.mRouteRepository = routesRepository;
        this.mCode = code;
    }

    @Override
    public void finalize() {
        this.mRouteRepository.releaseRepository();
    }

    @Override
    protected Observable<Iterable<StopBase>> buildInteractorObservable() {
        return mRouteRepository.getRoute(mCode);
    }
}
