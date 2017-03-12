package com.quoders.apps.madridbus.domain.interactors.lines;

import com.quoders.apps.madridbus.BaseInteractor;
import com.quoders.apps.madridbus.domain.network.EmtRestApi;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.model.LineBase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class LineListInteractor extends BaseInteractor {

    private EmtRestApi mEmtRestApi;
    private LinesRepository mLinesRepository;

    @Inject
    public LineListInteractor(EmtRestApi mEmtRestApi, LinesRepository linesRepository) {
        this.mEmtRestApi = mEmtRestApi;
        this.mLinesRepository = linesRepository;
    }

    @Override
    protected Observable<Iterable<LineBase>> buildInteractorObservable() {
        return mLinesRepository.getLinesList();
    }

    @Override
    public void execute(Observer observer) {
        super.execute(observer);
    }
}
