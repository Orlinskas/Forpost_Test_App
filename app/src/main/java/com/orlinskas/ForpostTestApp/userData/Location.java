package com.orlinskas.ForpostTestApp.userData;

class Location {
    private Street street;
    private String city;
    private String state;
    private String postcode;
    private Coordinates coordinates;

    public Location(Street street, String city, String state, String postcode, Coordinates coordinates) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }
}
