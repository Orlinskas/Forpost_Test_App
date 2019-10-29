package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

@Parcel
public class Id {
    private String name;
    private String value;

    Id() {
    }

    public Id(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id)) return false;
        Id id = (Id) o;
        return Objects.equals(getName(), id.getName()) &&
                Objects.equals(getValue(), id.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getValue());
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
