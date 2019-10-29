package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

@Parcel
public class Name {
    private String title;
    private String first;
    private String last;

    Name() {
    }

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(getTitle(), name.getTitle()) &&
                Objects.equals(getFirst(), name.getFirst()) &&
                Objects.equals(getLast(), name.getLast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getFirst(), getLast());
    }

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
