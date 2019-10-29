package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
class Coordinates {
    private String latitude;
    private String longitude;

    Coordinates() {
    }

    public Coordinates(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
