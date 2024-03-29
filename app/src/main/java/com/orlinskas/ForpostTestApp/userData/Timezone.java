package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
class Timezone {
    private String offset;
    private String description;

    Timezone() {
    }

    public Timezone(String offset, String description) {
        this.offset = offset;
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public String getDescription() {
        return description;
    }
}
