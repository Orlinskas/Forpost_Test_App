package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
public class Id {
    private String name;
    private String value;

    public Id(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
