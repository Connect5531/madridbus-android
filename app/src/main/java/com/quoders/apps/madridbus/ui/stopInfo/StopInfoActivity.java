package com.quoders.apps.madridbus.ui.stopInfo;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.quoders.apps.madridbus.BaseActivity;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.domain.repository.stopInfo.StopInfoRepositoryModule;
import com.quoders.apps.madridbus.model.arrivals.Arrivals;
import com.quoders.apps.madridbus.model.arrivals.Arrive;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StopInfoActivity extends BaseActivity implements StopInfoContract.View, ArrivalItemClickListener {

    public static String INTENT_EXTRA_STOP_CODE = "com.quoders.apps.madridbus.ui.stopInfo.INTENT_EXTRA_STOP_CODE";

    @Inject
    StopInfoPresenter mPresenter;

    private ArrivalsRecyclerViewAdapter mAdapter;
    private ContentLoadingProgressBar mProgressBar;
    private String mStopCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_info);

        mProgressBar = (ContentLoadingProgressBar)findViewById(R.id.progressBarStopInfo);

        initialiseRecyclerView();

        mStopCode = getIntent().getStringExtra(INTENT_EXTRA_STOP_CODE);

        DaggerStopInfoComponent.builder()
            .applicationComponent(getApplicationComponent())
                .stopInfoPresenterModule(new StopInfoPresenterModule(this))
                .stopInfoRepositoryModule(new StopInfoRepositoryModule(mStopCode))
                .build().inject(this);

        mPresenter.start();
    }

    private void initialiseRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewStopInfoArrivals);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Arrive> arrivals = new ArrayList<>();
        mAdapter = new ArrivalsRecyclerViewAdapter(arrivals, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setPresenter(StopInfoContract.Presenter presenter) {

    }

    @Override
    public void showErrorGettingArrivals() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_dialog_generic_title)
                .setMessage(R.string.error_dialog_stop_arrivals)
                .setNeutralButton(R.string.dialog_button_neutral, null)
                .show();
    }

    @Override
    public void onArrivalClick(Arrive arrive) {

    }

    @Override
    public void displayArrivals(@NotNull Arrivals arrivals) {
        mAdapter.setItems(arrivals.getArrives());
        mAdapter.notifyDataSetChanged();
    }
}
