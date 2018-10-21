package com.bensan.slhomework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        EditText input = (EditText)findViewById(R.id.locName);
        MapsActivity.setQuery(input.getText().toString());
        startActivity(intent);
    }
}
