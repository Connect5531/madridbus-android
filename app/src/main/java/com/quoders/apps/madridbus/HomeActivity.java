package com.quoders.apps.madridbus;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.quoders.apps.madridbus.ui.lines.LinesFragment;
import com.quoders.apps.madridbus.ui.lines.dummy.DummyContent;
import com.quoders.apps.madridbus.ui.map.HomeMapFragment;

public class HomeActivity extends AppCompatActivity implements
        HomeContract.View,
        NavigationView.OnNavigationItemSelectedListener,
        HomeMapFragment.OnFragmentInteractionListener,
        LinesFragment.OnListFragmentInteractionListener,
        TabLayout.OnTabSelectedListener {

    public static final int TAB_MAP_POSITION = 0;
    public static final int TAB_LINES_POSITION = 1;
    public static final int TAB_FAVORITES_POSITION = 2;

    private HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initTabLayout();

        initFabSearch();

        initNavigationDrawer(toolbar);

        displayMapView();

        mPresenter = new HomePresenter(this);
    }

    private void initTabLayout() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutHome);
        tabLayout.addOnTabSelectedListener(this);
    }

    private void initFabSearch() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initNavigationDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void displayMapView() {
        HomeMapFragment homeMapFragment = (HomeMapFragment) getSupportFragmentManager().findFragmentByTag(HomeMapFragment.FRAGMENT_TAG);
        if(homeMapFragment == null) {
            homeMapFragment = HomeMapFragment.newInstance("", "");
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutHomeContainer, homeMapFragment).commit();
    }

    @Override
    public void displayLinesView() {
        LinesFragment linesFragment = (LinesFragment) getSupportFragmentManager().findFragmentByTag(LinesFragment.FRAGMENT_TAG);
        if(linesFragment == null) {
            linesFragment = LinesFragment.newInstance(1);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutHomeContainer, linesFragment).commit();
    }

    @Override
    public void displayFavoritesView() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case TAB_MAP_POSITION:
                mPresenter.onMapTabSelected();
                break;
            case TAB_LINES_POSITION:
                mPresenter.onLinesTabSelected();
                break;
            case TAB_FAVORITES_POSITION:
                mPresenter.onFavoritesTabSelected();
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
