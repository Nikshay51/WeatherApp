package com.vc.weatherapp;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtil {
    private static final String BASE_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/30565";
    private static final String API_KEY = "prBhGpGAWYB2mG9ByeLBLFQg4pwWGNoW";
    private static final String PARAM_API_KEY = "apikey";
    private static final String METRIC_PARAM = "metric";
    private static final String METRIC_VALUE = "true";

    public static URL buidlURL() {
        Uri uri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendQueryParameter(PARAM_API_KEY, API_KEY)
                .appendQueryParameter(METRIC_PARAM, METRIC_VALUE)
                .build();

        URL url = null;

        try {
            url = new URL((uri).toString());

        } catch (MalformedURLException e) {
            e.printStackTrace(); //autocomplete
        }
        return url;
    }
}
