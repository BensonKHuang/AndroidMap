package com.bensan.slhomework4;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public static void setQuery(String query){
        MapsActivity.query = query;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Geocoder geoDude = new Geocoder(this, Locale.getDefault());
        double lat = 999;
        double lng = 999;

        try {
            List<Address> addrs = geoDude.getFromLocationName(query, 1);
            if(addrs.size() > 0){
                lat = addrs.get(0).getLatitude();
                lng = addrs.get(0).getLongitude();
            }
        } catch(Exception e){
            Log.e("Bensan Error", e.toString());
        };

        if(lat != 999){
            LatLng marker = new LatLng(lat, lng);
            mMap.addMarker(new MarkerOptions().position(marker).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        } else {

        }
    }
}
