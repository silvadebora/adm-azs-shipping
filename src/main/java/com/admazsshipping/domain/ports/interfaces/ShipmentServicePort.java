package com.admazsshipping.domain.ports.interfaces;

import com.admazsshipping.domain.Address;
import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.AddressDTO;
import org.springframework.data.domain.Page;

public interface ShipmentServicePort {

    Shipment insert(Shipment shipmentData);
    Page<Shipment> findShipment(String searchTerm, Integer page, Integer size);
    Shipment findById(String shipmentId);
    Shipment update(String id, Shipment shipment);
    void delete(String id);
    Address mapDTOToEntity(AddressDTO data);
}