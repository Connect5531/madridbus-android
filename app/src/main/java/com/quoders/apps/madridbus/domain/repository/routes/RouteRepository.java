package com.quoders.apps.madridbus.domain.repository.routes;

import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.StopBase;

import io.reactivex.Observable;

public interface RouteRepository extends Repository {

    Observable <Iterable<StopBase>> getRoute(String code);
}
