package com.vc.weatherapp;

import static java.lang.System.in;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {
    private static final String BASE_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/30565";
    private static final String API_KEY = "prBhGpGAWYB2mG9ByeLBLFQg4pwWGNoW";
    private static final String PARAM_API_KEY = "apikey";
    private static final String METRIC_PARAM = "metric";
    private static final String METRIC_VALUE = "true";
    private static String TAG = "NETWORK_UTIL";

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

    public static String getResponse(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();//get access from the finally block

        //connect URL
        try
        {
            //gets input from the http get request response
            InputStream in = httpURLConnection.getInputStream();
            //reads json into a string
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("//A");//delimeter for json
            boolean hasinput = scanner.hasNext();//do we have chunk data to work with

            if(hasinput)
            {
               return scanner.next(); //
            }
            else
            {
                Log.i(TAG,"getResponse: " + scanner.next());
                return null;
            }

        }

        //close connection at the end
        finally
        {
            httpURLConnection.disconnect();
        }

    }
}
