package com.growingio.android.sdk.models;
/* loaded from: classes2.dex */
public class LocationBean {
    private String city;
    private String country;
    private String countryCode;
    private double latitude;
    private double longitude;
    private String region;

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getRegion() {
        return this.region;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public String toJson() {
        return null;
    }
}
