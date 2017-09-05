package com.quoders.apps.madridbus.ui.map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class LocationMng {

    private static final float MAX_ACCURACY = 80f;

    private final Activity mActivity;
    private LocationManagerCallback mCallback;
    protected Location mCurrentLocation;
    private LocationManager mLocationManager;
    private LocationListener locationListener;
    private boolean mPermissionGranted;


    public LocationMng(Activity activity, LocationManagerCallback callback) {
        this.mActivity = activity;
        this.mCallback = callback;
        checkPermission();
    }

    private boolean checkPermission() {
        Dexter.withActivity(mActivity)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
                        mPermissionGranted = true;
                        initialiseLocationManager();
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {
                        mPermissionGranted = false;
                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        Log.i("madrid-bus-permissions", "onPermissionRationaleShouldBeShown");
                    }
                })
                .check();

        return mPermissionGranted;
    }

    private void initialiseLocationManager() {

        // Acquire a reference to the system Location Manager
        mLocationManager = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);

        // Define a listener that responds to location updates
        locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                makeUseOfNewLocation(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };
    }

    private void makeUseOfNewLocation(Location location) {
        Log.i("mb-location-provider", location.getProvider());
        Log.i("mb-location-accuracy", String.valueOf(location.getAccuracy()));
        Log.i("mb-location-altitude", String.valueOf(location.getAltitude()));
    }

    @SuppressLint("MissingPermission")
    public void startLocationUpdates() {
        if (mLocationManager != null && mPermissionGranted) {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    public void stopLocationUpdates() {
        if (mLocationManager != null && mPermissionGranted) {
            mLocationManager.removeUpdates(locationListener);
        }
    }

    @SuppressLint("MissingPermission")
    public Location getLastKnownLocation() {
        if(mPermissionGranted) {
            String locationProvider = LocationManager.NETWORK_PROVIDER;  // Or use LocationManager.GPS_PROVIDER
            mCurrentLocation = mLocationManager.getLastKnownLocation(locationProvider);
            return mCurrentLocation;
        }
        return null;
    }

    public boolean isPermissionGranted() {
        return mPermissionGranted;
    }

    public interface LocationManagerCallback {
        void onLocationUpdate(Location location);
        void onLocationFail();
    }
}
