package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import io.reactivex.Observable;

public interface LinesListInteractor {

    Observable<ListLineInfoEmt> getLinesList(String date);
}
