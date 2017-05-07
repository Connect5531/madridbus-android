package com.quoders.apps.madridbus.ui.routes;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.quoders.apps.madridbus.BaseActivity;
import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.domain.repository.routes.RoutesRepositoryModule;
import com.quoders.apps.madridbus.ui.model.LineUI;
import com.quoders.apps.madridbus.ui.routes.dummy.DummyContent;
import com.quoders.apps.madridbus.ui.routes.list.RouteListFragment;
import com.quoders.apps.madridbus.ui.routes.map.RouteMapFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LineRouteActivity extends BaseActivity implements LineRouteContract.View,
        RouteListFragment.OnListFragmentInteractionListener,
        RouteMapFragment.OnFragmentInteractionListener {

    public static final String INTENT_EXTRA_LINE = "com.quoders.apps.madridbus.ui.routes.INTENT_EXTRA_LINE";

    private RouteListFragment mListFragment;
    private RouteMapFragment mMapFragment;

    private RouteSectionsPagerAdapter mRouteSectionsPagerAdapter;

    @BindView(R.id.tabLayoutRoute)
    TabLayout mTabLayoutRoute;
    @BindView(R.id.viewPagerRoute)
    ViewPager mViewPagerRoute;

    @Inject
    LineRoutePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_route);

        ButterKnife.bind(this);

        LineUI line = (LineUI) getIntent().getSerializableExtra(INTENT_EXTRA_LINE);

        DaggerLineRouteComponent.builder()
                .applicationComponent(getApplicationComponent())
                .lineRoutePresenterModule(new LineRoutePresenterModule(this, line))
                .routesRepositoryModule(new RoutesRepositoryModule(line.getCode()))
                .build().inject(this);

        initTabsView();
        initFragments();
    }

    private void initFragments() {
        mListFragment = RouteListFragment.newInstance(1);
        mMapFragment = RouteMapFragment.newInstance("", "");
    }

    private void initTabsView() {
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

    }

    @Override
    public void dismissProgressBar() {

    }

    @Override
    public void showErrorLoadingList() {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

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
