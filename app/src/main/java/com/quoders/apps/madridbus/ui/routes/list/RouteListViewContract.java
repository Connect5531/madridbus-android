package com.quoders.apps.madridbus.ui.routes.list;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.StopBase;

import java.util.List;

public interface RouteListViewContract {

    interface View extends BaseView<Presenter> {
        void displayRoute(List<StopBase> stops);
    }

    interface Presenter extends BasePresenter {

    }
}
