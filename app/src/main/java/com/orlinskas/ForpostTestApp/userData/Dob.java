package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dob)) return false;
        Dob dob = (Dob) o;
        return Objects.equals(getDate(), dob.getDate()) &&
                Objects.equals(getAge(), dob.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAge());
    }

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }
}
