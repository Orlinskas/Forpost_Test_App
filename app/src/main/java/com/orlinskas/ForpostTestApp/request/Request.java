package com.orlinskas.ForpostTestApp.request;

import com.orlinskas.ForpostTestApp.Settings;

public class Request {
    private String source;
    private String resultCount;

    public Request() {
        this.source = Settings.URL_SOURCE;
        this.resultCount = String.valueOf(Settings.RESULT_COUNT);
    }

    String getSource() {
        return source;
    }

    String getResultCount() {
        return resultCount;
    }
}
