package com.orlinskas.ForpostTestApp.userData;

import org.parceler.Parcel;

import java.util.Objects;

@Parcel
public class Login {
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    Login() {
    }

    public Login(String uuid, String username, String password, String salt, String md5, String sha1, String sha256) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return Objects.equals(getUuid(), login.getUuid()) &&
                Objects.equals(getUsername(), login.getUsername()) &&
                Objects.equals(getPassword(), login.getPassword()) &&
                Objects.equals(getSalt(), login.getSalt()) &&
                Objects.equals(getMd5(), login.getMd5()) &&
                Objects.equals(getSha1(), login.getSha1()) &&
                Objects.equals(getSha256(), login.getSha256());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getUsername(), getPassword(), getSalt(), getMd5(), getSha1(), getSha256());
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getMd5() {
        return md5;
    }

    public String getSha1() {
        return sha1;
    }

    public String getSha256() {
        return sha256;
    }
}
