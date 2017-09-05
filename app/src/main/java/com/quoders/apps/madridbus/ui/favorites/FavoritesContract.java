package com.quoders.apps.madridbus.ui.favorites;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.favorites.FavoriteBase;

import java.util.List;

public class FavoritesContract {

    interface View extends BaseView<Presenter> {

        void showProgressBar();

        void setFavoritesList(List<FavoriteBase> resultValues);

        void showErrorLoadingList();

        void dismissProgressBar();

        void showEmptyFavoritesMessage();

        void hideEmptyFavoritesMessage();
    }

    interface Presenter extends BasePresenter {
    }

}
