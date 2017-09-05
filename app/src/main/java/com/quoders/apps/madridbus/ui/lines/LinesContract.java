package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.ui.model.LineUI;

import java.util.List;

public class LinesContract {

    interface View extends BaseView<Presenter> {

        void showProgressBar();

        void setLinesList(List<LineUI> resultValues);

        void showErrorLoadingList();

        void dismissProgressBar();
    }

    interface Presenter extends BasePresenter {
    }

}
