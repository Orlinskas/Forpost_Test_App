package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;
        Picture picture = (Picture) o;
        return Objects.equals(getLarge(), picture.getLarge()) &&
                Objects.equals(getMedium(), picture.getMedium()) &&
                Objects.equals(getThumbnail(), picture.getThumbnail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLarge(), getMedium(), getThumbnail());
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