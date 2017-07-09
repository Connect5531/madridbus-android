package com.quoders.apps.madridbus.domain.repository.favorites;

import com.quoders.apps.madridbus.domain.repository.LocalRepository;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;
import io.realm.RealmResults;


public class FavoritesLocalRepository implements LocalRepository<FavoriteBase> {

    private final Realm mRealm;

    @Inject
    public FavoritesLocalRepository(Realm mRealm) {
        this.mRealm = mRealm;
    }

    @Override
    public void add(final FavoriteBase favorite) {
        mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(favorite));
    }

    @Override
    public void add(final Iterable<FavoriteBase> favorites) {
        mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(favorites));
    }

    @Override
    public void update(final FavoriteBase favorite) {
        mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(favorite));
    }

    @Override
    public void remove(FavoriteBase item) {
        final RealmResults<FavoriteBase> items = mRealm.where(FavoriteBase.class)
                .equalTo(FavoriteBase.ID, item.getId()).findAll();

        mRealm.executeTransaction(realm -> items.deleteAllFromRealm());
    }


    @Override
    public Observable<FavoriteBase> query() {
        return Observable.empty();
    }

    @Override
    public Observable<Iterable<FavoriteBase>> queryItems() {
        return Observable.fromCallable((Callable<Iterable<FavoriteBase>>) () ->
                mRealm.where(FavoriteBase.class).findAll())
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void close() {
        mRealm.close();
    }
}
