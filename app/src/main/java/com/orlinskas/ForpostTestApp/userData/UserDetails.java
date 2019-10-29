package com.orlinskas.ForpostTestApp.userData;

public class UserDetails {
    private String detailsName;
    private String detailsValue;

    public UserDetails(String detailsName, String detailsValue) {
        this.detailsName = detailsName;
        this.detailsValue = detailsValue;
    }

    public String getDetailsName() {
        return detailsName;
    }

    public String getDetailsValue() {
        return detailsValue;
    }
}
