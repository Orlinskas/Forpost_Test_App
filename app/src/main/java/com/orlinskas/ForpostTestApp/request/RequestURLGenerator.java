package com.orlinskas.ForpostTestApp.request;

import android.net.Uri;

import java.net.URL;

class RequestURLGenerator {
    private final String RESULTS = "results";

    URL generate(Request request) {
        Uri builder = Uri.parse(request.getSource())
                .buildUpon()
                .appendQueryParameter(RESULTS, request.getResultCount())
                .build();

        URL requestOpenWeather = null;
        try {
            requestOpenWeather = new URL(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestOpenWeather;
    }
}
