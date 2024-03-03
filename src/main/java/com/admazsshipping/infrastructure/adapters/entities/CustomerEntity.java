package com.admazsshipping.infrastructure.adapters.entities;

import com.admazsshipping.domain.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private String documentNumber;
    private String email;
    private AddressEntity address;
    private String phoneNumber;

    public CustomerEntity() {
    }

    public CustomerEntity(String id, String name, String documentNumber,
                          String email, AddressEntity address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer toCustomer(){
        return new Customer(this.id, this.name, this.documentNumber,
        this.email, this.address.toAddress(), this.phoneNumber);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
