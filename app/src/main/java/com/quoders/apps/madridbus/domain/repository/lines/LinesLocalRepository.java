package com.quoders.apps.madridbus.domain.repository.lines;

import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.LineBase;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class LinesLocalRepository implements Repository<LineBase> {

    private final Realm mRealm;

    @Inject
    public LinesLocalRepository(Realm mRealm) {
        this.mRealm = mRealm;
    }

    @Override
    public void add(final LineBase line) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(line);
            }
        });
    }

    @Override
    public void add(final Iterable<LineBase> lines) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(lines);
            }
        });
    }

    @Override
    public void update(final LineBase line) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(line);
            }
        });
    }

    @Override
    public void remove(LineBase item) {
        final RealmResults<LineBase> items = mRealm.where(LineBase.class).equalTo(LineBase.CODE, item.getCode()).findAll();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                items.deleteAllFromRealm();
            }
        });
    }

    @Override
    public Observable<List<LineBase>> query() {
        return Observable.fromCallable(new Callable<LineBase>() {
            @Override
            public LineBase call() throws Exception {
                final RealmResults<LineBase> all = mRealm.where(LineBase.class).findAll();
            }
        });
    }

/*
    @Override
    public List<LineBase> query() {
        return mRealm.where(LineBase.class).findAll();
    }
*/
}
