package com.quoders.apps.madridbus;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseInteractor {

    public abstract void release();

    protected abstract Observable buildInteractorObservable();

    public void execute(Observer observer) {
        buildInteractorObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(observer);
    }
}
