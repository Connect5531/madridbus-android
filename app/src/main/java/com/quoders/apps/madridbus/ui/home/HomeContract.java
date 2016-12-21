package com.quoders.apps.madridbus.ui.home;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;

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
