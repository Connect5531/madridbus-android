package com.quoders.apps.madridbus.domain.interactors.route;

import com.quoders.apps.madridbus.BaseInteractor;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.domain.repository.routes.RouteRepository;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class RouteInteractor extends BaseInteractor {

    private RouteRepository mRouteRepository;
    private String mCode;

    @Inject
    public RouteInteractor(RouteRepository routesRepository, String code) {
        this.mRouteRepository = routesRepository;
        this.mCode = code;
    }

    @Override
    public void release() {
        this.mRouteRepository.releaseRepository();
    }

    @Override
    protected Observable<List<StopBase>> buildInteractorObservable() {
        return mRouteRepository.getRoute(mCode)
                .map(stopBases -> {
                    List<StopBase> stops = new ArrayList<>();
                    for (StopBase stop : stopBases) {
                        stops.add(stop);
                    }
                    return stops;
                });
    }
}
