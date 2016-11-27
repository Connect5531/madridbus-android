package com.quoders.apps.madridbus;

public interface BasePresenter {

    void onViewAttached(BaseView view);

    void onViewDetached();
}
