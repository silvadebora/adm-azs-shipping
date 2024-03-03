package com.admazsshipping.domain.ports.repositories;

import com.admazsshipping.domain.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipmentRepositoryPort {

    Shipment insert(Shipment shipment);

    Page<Shipment> findShipment(String customerId, Pageable pageable);

    Shipment findById(String shipmentId);

    Shipment update(String id, Shipment shipment);

    void delete(String id);
}
