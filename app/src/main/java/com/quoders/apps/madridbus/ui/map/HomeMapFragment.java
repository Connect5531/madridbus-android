package com.quoders.apps.madridbus.ui.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.quoders.apps.madridbus.R;

public class HomeMapFragment extends Fragment implements OnMapReadyCallback,
        GoogleMap.OnMapLongClickListener, LocationMng.LocationManagerCallback {

    public static final String FRAGMENT_TAG = "com.quoders.apps.madridbus.ui.map.MapFragment.FRAGMENT_TAG";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int MAP_ZOOM_LEVEL_NORMAL = 14;

    private OnFragmentInteractionListener mListener;
    private Marker mMarker;
    private LocationMng mLocationMng;
    private GoogleMap mMap;


    public HomeMapFragment() {
        // Required empty public constructor
    }

    public static HomeMapFragment newInstance(String param1, String param2) {
        HomeMapFragment fragment = new HomeMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_map, container, false);
        final SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapHome);
        supportMapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Map is ready to be used.
        mMap = googleMap;

        // Set the long click listener as a way to exit the map.
        mMap.setOnMapLongClickListener(this);

        initialiseLocationManager();
    }

    private void initialiseLocationManager() {
        mLocationMng = new LocationMng(getActivity(), this);
        onLocationUpdate(mLocationMng.getLastKnownLocation());
        mLocationMng.startLocationUpdates();
    }

    @Override
    public void onLocationUpdate(Location location) {
        if (location != null && mMap != null) {
            LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
            mMarker = mMap.addMarker(new MarkerOptions().position(loc));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16.0f));
        }
    }

    @Override
    public void onLocationFail() {
        Log.i("madrid-bus-location", "onLocationFail");
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
