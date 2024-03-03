package com.admazsshipping.domain;

import com.admazsshipping.domain.dto.AddressDTO;

public class Address {

    private String street;
    private String number;
    private String city;
    private String zipCode;


    public Address() {
    }

    public Address(String street, String number, String city, String zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Address(AddressDTO data){
        this.street = data.street();
        this.number = data.number();
        this.city = data.city();
        this.zipCode = data.zipCode();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
