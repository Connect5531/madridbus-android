package com.quoders.apps.madridbus.ui.routes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.quoders.apps.madridbus.BaseActivity;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.domain.repository.routes.RoutesRepositoryModule;
import com.quoders.apps.madridbus.model.StopBase;
import com.quoders.apps.madridbus.ui.model.LineUI;
import com.quoders.apps.madridbus.ui.routes.list.RouteListFragment;
import com.quoders.apps.madridbus.ui.routes.map.RouteMapFragment;
import com.quoders.apps.madridbus.ui.stopInfo.StopInfoActivity;

import java.util.List;

import javax.inject.Inject;

public class LineRouteActivity extends BaseActivity implements LineRouteContract.View,
        RouteListFragment.OnListFragmentInteractionListener,
        RouteMapFragment.OnFragmentInteractionListener {

    public static final String INTENT_EXTRA_LINE = "com.quoders.apps.madridbus.ui.routes.INTENT_EXTRA_LINE";

    private RouteListFragment mListFragment;
    private RouteMapFragment mMapFragment;

    private RouteSectionsPagerAdapter mRouteSectionsPagerAdapter;

    TabLayout mTabLayoutRoute;
    ViewPager mViewPagerRoute;
    ContentLoadingProgressBar mProgressBar;

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

        initTabsView();
        initFragments();
        initProgressBar();
    }

    private void initProgressBar() {
        mProgressBar = (ContentLoadingProgressBar) findViewById(R.id.progressBarRouteList);
    }

    private void initFragments() {
        mListFragment = RouteListFragment.newInstance(1);
        mMapFragment = RouteMapFragment.newInstance("", "");
    }

    private void initTabsView() {
        mTabLayoutRoute = (TabLayout) findViewById(R.id.tabLayoutRoute);
        mViewPagerRoute = (ViewPager) findViewById(R.id.viewPagerRoute);

        mRouteSectionsPagerAdapter = new RouteSectionsPagerAdapter(getSupportFragmentManager());
        mViewPagerRoute.setAdapter(mRouteSectionsPagerAdapter);
        mTabLayoutRoute.setupWithViewPager(mViewPagerRoute);
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
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorLoadingList() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_dialog_generic_title)
                .setMessage(R.string.error_dialog_line_list_message)
                .setNeutralButton(R.string.dialog_button_neutral, null)
                .show();
    }

    @Override
    public void displayRoute(List<StopBase> stops) {
        mListFragment.displayRoute(stops);
        //mMapFragment.displayRoute(stops);
    }

    @Override
    public void displayStopDetail(StopBase stop) {
        Intent intent = new Intent(this, StopInfoActivity.class);
        intent.putExtra(StopInfoActivity.INTENT_EXTRA_STOP_CODE, stop.getCode());
        startActivity(intent);
    }

    @Override
    public void showFavoriteAddedSuccessMessage() {
        Toast.makeText(this, R.string.favorite_added_success, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorAddingFavoriteMessage() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_dialog_generic_title)
                .setMessage(R.string.error_dialog_line_list_message)
                .setNeutralButton(R.string.dialog_button_neutral, null)
                .show();
    }

    @Override
    public void onListFragmentInteraction(StopBase item) {
        mPresenter.onStopClicked(item);
    }

    @Override
    public void onSetFavoriteStop(StopBase stop) {
        mPresenter.onAddStopToFavoritesClick(stop);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class RouteSectionsPagerAdapter extends FragmentPagerAdapter {

        public RouteSectionsPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return mListFragment;
            } else {
                return mMapFragment;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
