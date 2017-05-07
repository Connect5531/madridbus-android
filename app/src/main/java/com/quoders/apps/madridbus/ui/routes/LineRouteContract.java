package com.quoders.apps.madridbus.ui.routes;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.LineBase;

public interface LineRouteContract {

    interface View extends BaseView {

        void showProgressBar();

        void dismissProgressBar();

        void showErrorLoadingList();
    }

    interface Presenter extends BasePresenter {

    }
}
