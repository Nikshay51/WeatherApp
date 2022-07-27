package com.vc.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "AccuWeatherURL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URL accuweatherURL = NetworkUtil.buidlURL();
        Log.i(TAG, "onCreate: " + accuweatherURL);

    }
}