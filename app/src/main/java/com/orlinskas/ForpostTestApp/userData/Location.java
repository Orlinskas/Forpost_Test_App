package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

@Parcel
public class Location {
    private Street street;
    private String city;
    private String state;
    private String postcode;
    private Coordinates coordinates;

    Location() {
    }

    public Location(Street street, String city, String state, String postcode, Coordinates coordinates) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getStreet(), location.getStreet()) &&
                Objects.equals(getCity(), location.getCity()) &&
                Objects.equals(getState(), location.getState()) &&
                Objects.equals(getPostcode(), location.getPostcode()) &&
                Objects.equals(getCoordinates(), location.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getCity(), getState(), getPostcode(), getCoordinates());
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
