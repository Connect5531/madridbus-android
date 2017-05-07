package com.quoders.apps.madridbus.ui.home;

import android.support.annotation.NonNull;

import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.ui.model.LineUI;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    @Inject
    public HomePresenter(@NonNull HomeContract.View view) {
        mView = view;
    }

    @Override
    public void onMapTabSelected() {
        mView.displayMapView();
    }

    @Override
    public void onLinesTabSelected() {
        mView.displayLinesView();
    }

    @Override
    public void onFavoritesTabSelected() {
        mView.displayFavoritesView();
    }

    @Override
    public void onLineSelected(LineUI line) {
        mView.displayLineRoute(line);
    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}
