package com.ankitud.domain;

public class Address {
    private int addressId;
    private String city;
    private String pincode;

    public Address(){

    }

    public Address(int addressId, String city, String pincode) {
        this.addressId = addressId;
        this.city = city;
        this.pincode = pincode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
