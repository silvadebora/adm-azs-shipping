package com.admazsshipping.domain.dto;

import com.admazsshipping.domain.Customer;

public record CustomerDTO(String name, String documentNumber,
                          String email, AddressDTO address, String phoneNumber) {

    public Customer toEntity() {
        if (this.name() == null || this.documentNumber() == null ||
                this.email() == null || this.address() == null || this.phoneNumber() == null) {
            throw new IllegalArgumentException("Name, documentNumber, email, address and phoneNumber fields in Customer are mandatory.");
        }

        return new Customer(
                null,
                this.name(),
                this.documentNumber(),
                this.email(),
                this.address().toEntity(),
                this.phoneNumber()
        );
    }
}
