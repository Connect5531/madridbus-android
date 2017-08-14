package com.quoders.apps.madridbus.domain.repository.favorites;

import com.quoders.apps.madridbus.domain.repository.Repository;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import io.reactivex.Observable;

public interface FavoritesRepository extends Repository {

    Observable<Iterable<FavoriteBase>> getFavorites();

    void addFavorite(FavoriteBase favorite);
}
