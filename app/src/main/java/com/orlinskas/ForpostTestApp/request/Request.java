package com.orlinskas.ForpostTestApp.request;

import com.orlinskas.ForpostTestApp.DateHelper;
import com.orlinskas.ForpostTestApp.Settings;

class Request {
    private String date;
    private String source;
    private String resultCount;

    Request() {
        this.date = DateHelper.getCurrent(Settings.DEFAULT_DATE_FORMAT);
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
