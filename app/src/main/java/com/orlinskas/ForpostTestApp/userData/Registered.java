package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registered)) return false;
        Registered that = (Registered) o;
        return Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAge());
    }

    public String getDate() {
        return date;
    }

    public Integer getAge() {
        return age;
    }
}