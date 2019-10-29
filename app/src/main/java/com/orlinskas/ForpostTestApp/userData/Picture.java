package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
public class Picture {
    private String large;
    private String medium;
    private String thumbnail;

    Picture() {
    }

    public Picture(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}