package com.quoders.apps.madridbus.domain.repository.lines;

import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.LineBase;

import io.reactivex.Observable;

public interface LinesRepository extends Repository {

    Observable<Iterable<LineBase>> getLinesList();
}
