package com.admazsshipping.domain.dto;

import com.admazsshipping.domain.Customer;
import com.admazsshipping.domain.Shipment;

public record ShipmentDTO(String origin, AddressDTO destination, String loadDescription, Double weight,
                          Double volume, Double cubage, String sender, String receiver, String status) {

    public Shipment toEntity(Customer sender) {
        if (this.origin() == null || this.destination() == null || this.sender() == null
                || this.receiver() == null ) {
            throw new IllegalArgumentException("Origin, destination, sender and receiver fields in Shipment are mandatory.");
        }

        return new Shipment(
                null,
                this.origin(),
                this.destination().toEntity(),
                sender,
                this.receiver(),
                this.status()
        );
    }
}
