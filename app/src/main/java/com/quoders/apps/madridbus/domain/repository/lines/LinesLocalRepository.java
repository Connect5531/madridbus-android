package com.quoders.apps.madridbus.domain.repository.lines;

import com.quoders.apps.madridbus.domain.repository.LocalRepository;
import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.LineBase;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;
import io.realm.RealmResults;


public class LinesLocalRepository implements LocalRepository<LineBase> {

    private final Realm mRealm;

    @Inject
    public LinesLocalRepository(Realm mRealm) {
        this.mRealm = mRealm;
    }

    @Override
    public void add(final LineBase line) {
        mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(line));
    }

    @Override
    public void add(final Iterable<LineBase> lines) {
        mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(lines));
    }

    @Override
    public void update(final LineBase line) {
        mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(line));
    }

    @Override
    public void remove(LineBase item) {
        final RealmResults<LineBase> items = mRealm.where(LineBase.class)
                .equalTo(LineBase.CODE, item.getCode()).findAll();

        mRealm.executeTransaction(realm -> items.deleteAllFromRealm());
    }


    @Override
    public Observable<LineBase> query() {
        return Observable.empty();
    }

    @Override
    public Observable<Iterable<LineBase>> queryItems() {
        return Observable.fromCallable((Callable<Iterable<LineBase>>) () ->
                mRealm.where(LineBase.class).findAll()).
                subscribeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void close() {
        mRealm.close();
    }
}
