package com.orlinskas.ForpostTestApp.request;


import com.orlinskas.ForpostTestApp.DateHelper;
import com.orlinskas.ForpostTestApp.userData.Settings;

import java.io.Serializable;

class Request implements Serializable {
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
