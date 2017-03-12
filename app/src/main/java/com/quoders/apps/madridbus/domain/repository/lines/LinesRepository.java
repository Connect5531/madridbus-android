package com.quoders.apps.madridbus.domain.repository.lines;

import com.quoders.apps.madridbus.model.LineBase;

import java.util.List;

import io.reactivex.Observable;

public interface LinesRepository  {

    Observable<Iterable<LineBase>> getLinesList();
}
