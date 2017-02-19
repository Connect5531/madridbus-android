package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import java.util.List;

import io.reactivex.Observable;

public interface LinesListInteractor {

    Observable<List<LineBase>> getLinesList(String date);

    void saveLinesList(List<LineBase> lines);
}
