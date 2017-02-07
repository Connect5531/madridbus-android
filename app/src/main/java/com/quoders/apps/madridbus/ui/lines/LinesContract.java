package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.LineBase;
import com.quoders.apps.madridbus.model.rest.LineInfoEmt;

import java.util.List;

import io.reactivex.Single;

public class LinesContract {

    interface View extends BaseView<Presenter> {

        void showProgressBar();

        void setLinesList(List<LineInfoEmt> resultValues);

        void showErrorLoadingList();

        void dismissProgressBar();
    }

    interface Presenter extends BasePresenter {
    }

}
