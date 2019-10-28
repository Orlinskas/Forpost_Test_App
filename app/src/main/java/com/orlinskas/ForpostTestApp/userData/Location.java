package com.orlinskas.ForpostTestApp.userData;

class Location {
    public Location(String street, String city, String state, String postcode, Coordinates coordinates) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    private String street;
    private String city;
    private String state;
    private String postcode;
    private Coordinates coordinates;
}
