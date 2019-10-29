package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
class Street {
    private int number;
    private String name;

    Street() {
    }

    public Street(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
