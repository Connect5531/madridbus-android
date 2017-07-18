package com.quoders.apps.madridbus.ui.routes;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.List;

public interface LineRouteContract {

    interface View extends BaseView {

        void showProgressBar();

        void dismissProgressBar();

        void showErrorLoadingList();

        void displayRoute(List<StopBase> stops);

        void displayStopDetail(StopBase item);
    }

    interface Presenter extends BasePresenter {

        void onStopClicked(StopBase item);
    }
}
