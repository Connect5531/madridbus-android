package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.BasePresenter;
import com.quoders.apps.madridbus.BaseView;
import com.quoders.apps.madridbus.model.LineBase;

import java.util.List;

import io.reactivex.Single;

public class LinesContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
    }

}
