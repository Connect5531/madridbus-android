package com.quoders.apps.madridbus.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.quoders.apps.madridbus.R;
import com.quoders.apps.madridbus.ui.lines.LinesFragment;
import com.quoders.apps.madridbus.ui.lines.dummy.DummyContent;
import com.quoders.apps.madridbus.ui.map.HomeMapFragment;

public class HomeActivity extends AppCompatActivity implements
        HomeContract.View,
        NavigationView.OnNavigationItemSelectedListener,
        HomeMapFragment.OnFragmentInteractionListener,
        LinesFragment.OnListFragmentInteractionListener {

    private HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = initToolBar();
        initNavigationDrawer(toolbar);
        initBottomNavigation();
        displayMapView();

        mPresenter = new HomePresenter(this);
    }

    private void initBottomNavigation() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_map:
                                mPresenter.onMapTabSelected();
                                break;
                            case R.id.action_list:
                                mPresenter.onLinesTabSelected();
                                break;
                            case R.id.action_favorites:
                                mPresenter.onFavoritesTabSelected();
                                break;
                        }
                        return true;
                    }
                });
    }

    private Toolbar initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
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
}