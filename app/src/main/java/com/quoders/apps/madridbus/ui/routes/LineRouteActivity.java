package com.quoders.apps.madridbus.ui.routes;

import android.os.Bundle;

import com.quoders.apps.madridbus.BaseActivity;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.domain.repository.routes.RoutesRepositoryModule;
import com.quoders.apps.madridbus.ui.model.LineUI;

import javax.inject.Inject;

public class LineRouteActivity extends BaseActivity implements LineRouteContract.View {

    public static final String INTENT_EXTRA_LINE = "com.quoders.apps.madridbus.ui.routes.INTENT_EXTRA_LINE";

    @Inject
    LineRoutePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_route);

        LineUI line = (LineUI) getIntent().getSerializableExtra(INTENT_EXTRA_LINE);

        DaggerLineRouteComponent.builder()
                .applicationComponent(getApplicationComponent())
                .lineRoutePresenterModule(new LineRoutePresenterModule(this, line))
                .routesRepositoryModule(new RoutesRepositoryModule(line.getCode()))
                .build().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void dismissProgressBar() {

    }

    @Override
    public void showErrorLoadingList() {

    }
}
