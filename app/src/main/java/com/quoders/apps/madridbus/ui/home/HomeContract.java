package com.quoders.apps.madridbus.ui.home;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.ui.model.LineUI;

public interface HomeContract {

    interface View extends BaseView {

        void displayMapView();

        void displayLinesView();

        void displayFavoritesView();

        void displayLineRoute(LineUI line);
    }

    interface Presenter extends BasePresenter {

        void onMapTabSelected();

        void onLinesTabSelected();

        void onFavoritesTabSelected();

        void onLineSelected(LineUI line);
    }
}
