package com.quoders.apps.madridbus.domain.repository.lines;

import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.LineBase;

import javax.inject.Inject;

import io.realm.Realm;
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
                mRealm.copyToRealm(line);
            }
        });
    }

    @Override
    public void add(final Iterable<LineBase> lines) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealm(lines);
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
}
