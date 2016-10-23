package com.quoders.apps.madridbus;

public interface HomeContract {

    interface View extends BaseView {

        void displayMapView();

        void displayLinesView();

        void displayFavoritesView();
    }

    interface Presenter extends BasePresenter {

        void onMapTabSelected();

        void onLinesTabSelected();

        void onFavoritesTabSelected();
    }
}
