package com.admazsshipping.domain.dto;

import com.admazsshipping.domain.Address;

public record AddressDTO(String street, String number, String city, String zipCode) {

    public Address toEntity() {
        return new Address(
                this.street(),
                this.number(),
                this.city(),
                this.zipCode()
        );
    }
}
