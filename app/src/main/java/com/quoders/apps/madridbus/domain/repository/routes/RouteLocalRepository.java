package com.quoders.apps.madridbus.domain.repository.routes;

import com.quoders.apps.madridbus.domain.repository.LocalRepository;
import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;
import io.realm.RealmResults;


public class RouteLocalRepository implements LocalRepository<StopBase> {

    private final Realm mRealm;

    @Inject
    public RouteLocalRepository(Realm mRealm) {
        this.mRealm = mRealm;
    }

    @Override
    public void add(final StopBase stop) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(stop);
            }
        });
    }

    @Override
    public void add(final Iterable<StopBase> stop) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(stop);
            }
        });
    }

    @Override
    public void update(final StopBase stop) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(stop);
            }
        });
    }

    @Override
    public void remove(StopBase item) {
        final RealmResults<LineBase> items = mRealm.where(LineBase.class).equalTo(LineBase.CODE, item.getCode()).findAll();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                items.deleteAllFromRealm();
            }
        });
    }


    @Override
    public Observable<StopBase> query() {
        return Observable.empty();
    }

    @Override
    public Observable<Iterable<StopBase>> queryItems() {
        return Observable.fromCallable(new Callable<Iterable<StopBase>>() {
            @Override
            public Iterable<StopBase> call() throws Exception {
                return mRealm.where(StopBase.class).findAll();
            }
        }).subscribeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Iterable<StopBase>> queryItems(final String code) {
        return Observable.fromCallable(new Callable<Iterable<StopBase>>() {
            @Override
            public Iterable<StopBase> call() throws Exception {
                String codeInt = Integer.valueOf(code).toString();
                return mRealm.where(StopBase.class).equalTo("line", codeInt).findAll();
            }
        }).subscribeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public void close() {
        mRealm.close();
    }
}
