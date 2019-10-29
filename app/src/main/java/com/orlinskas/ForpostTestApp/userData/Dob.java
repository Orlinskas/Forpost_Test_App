package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
public class Dob {
    private String date;
    private String age;

    Dob() {
    }

    public Dob(String date, String age) {
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }
}
