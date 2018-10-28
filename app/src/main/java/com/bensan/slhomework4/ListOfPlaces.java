package com.bensan.slhomework4;

import android.content.Intent;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlaces extends AppCompatActivity {
    private static List<Address> addrs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_places);

        final ListView listView = findViewById(R.id.listOfPlaces);
        ArrayList<String> items = new ArrayList<>();

        for(Address addr: addrs){
            items.add(addr.getAddressLine(0));
        }

        final Intent intent = new Intent(this, MapsActivity.class);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsActivity.setLatLng(addrs.get(position).getLatitude(), addrs.get(position).getLongitude());
                startActivity(intent);
            }
        });
    }
    public static void setAddrs(List<Address> addrs){
        ListOfPlaces.addrs = new ArrayList<>(addrs);
    }
}
