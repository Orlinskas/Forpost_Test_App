package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

@Parcel
public class User {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private Dob dob;
    private Registered registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
    private String nat;

    public User() {
    }

    public User(String gender, Name name, Location location, String email, Login login, Dob dob, Registered registered, String phone, String cell, Id id, Picture picture, String nat) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.id = id;
        this.picture = picture;
        this.nat = nat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLocation(), user.getLocation()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getDob(), user.getDob()) &&
                Objects.equals(getRegistered(), user.getRegistered()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getCell(), user.getCell()) &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getPicture(), user.getPicture()) &&
                Objects.equals(getNat(), user.getNat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGender(), getName(), getLocation(), getEmail(), getLogin(), getDob(), getRegistered(), getPhone(), getCell(), getId(), getPicture(), getNat());
    }

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public Dob getDob() {
        return dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Id getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }


}
