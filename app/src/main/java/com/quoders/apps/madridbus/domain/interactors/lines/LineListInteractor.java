package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.BaseInteractor;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.model.LineBase;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LineListInteractor extends BaseInteractor {

    private LinesRepository mLinesRepository;

    @Inject
    public LineListInteractor(LinesRepository linesRepository) {
        this.mLinesRepository = linesRepository;
    }

    @Override
    public void release() {
        this.mLinesRepository.releaseRepository();
    }

    @Override
    protected Observable<Iterable<LineBase>> buildInteractorObservable() {
        return mLinesRepository.getLinesList();
    }
}
