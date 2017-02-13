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
    public void add(LineBase line) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(line);
        mRealm.commitTransaction();
    }

    @Override
    public void add(Iterable<LineBase> lines) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(lines);
        mRealm.commitTransaction();
    }

    @Override
    public void update(LineBase line) {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(line);
        mRealm.commitTransaction();
    }

    @Override
    public void remove(LineBase item) {
        mRealm.beginTransaction();
        final RealmResults<LineBase> results = mRealm.where(LineBase.class).equalTo(LineBase.class.c)
        mRealm.where(LineBase.class).equalTo(LineBase.,userId).findAll();
        mRealm.commitTransaction();
    }
}
