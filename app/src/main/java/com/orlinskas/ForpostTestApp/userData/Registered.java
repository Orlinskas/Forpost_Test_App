package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

@Parcel
public class Registered {
    private String date;
    private Integer age;

    Registered() {
    }

    public Registered(String date, Integer age) {
        super();
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public Integer getAge() {
        return age;
    }
}