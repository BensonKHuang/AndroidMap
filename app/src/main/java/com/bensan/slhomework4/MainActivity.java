package com.bensan.slhomework4;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        EditText input = (EditText)findViewById(R.id.locName);

        Geocoder geoDude = new Geocoder(this, Locale.getDefault());
        double lat = 999;
        double lng = 999;

        try {
            List<Address> addrs = geoDude.getFromLocationName(input.getText().toString(), 1);
            if(addrs.size() > 0){
                lat = addrs.get(0).getLatitude();
                lng = addrs.get(0).getLongitude();
            }
        } catch(Exception e){
            Log.e("Bensan Error", e.toString());
        }

        if(lat != 999){
            MapsActivity.setLatLng(lat, lng);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Nothing found...", Toast.LENGTH_LONG).show();
        }
    }
}








