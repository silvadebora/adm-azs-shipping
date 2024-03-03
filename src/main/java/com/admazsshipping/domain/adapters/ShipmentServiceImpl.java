package com.admazsshipping.domain.adapters;

import com.admazsshipping.domain.Address;
import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.AddressDTO;
import com.admazsshipping.domain.ports.interfaces.ShipmentServicePort;
import com.admazsshipping.domain.ports.repositories.CustomerRepositoryPort;
import com.admazsshipping.domain.ports.repositories.ShipmentRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ShipmentServiceImpl implements ShipmentServicePort {

    private final ShipmentRepositoryPort shipmentRepository;

    private final CustomerRepositoryPort customerRepository;

    public ShipmentServiceImpl(ShipmentRepositoryPort shipmentRepository, CustomerRepositoryPort customerRepository) {
        this.shipmentRepository = shipmentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Shipment insert(Shipment shipment) {
        return this.shipmentRepository.insert(shipment);
    }

    @Override
    public Page<Shipment> findShipment(String searchTerm, Integer page, Integer size) {
        Pageable pageable;
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        } else {
            pageable = Pageable.unpaged();
        }
        return this.shipmentRepository.findShipment(searchTerm, pageable);
    }

    @Override
    public Shipment findById(String shipmentId) {
        return this.shipmentRepository.findById(shipmentId);
    }

    @Override
    public Shipment update(String id, Shipment shipment) {
        return this.shipmentRepository.insert(shipment);

    }

    @Override
    public void delete(String id) {
        this.shipmentRepository.delete(id);
    }

    @Override
    public Address mapDTOToEntity(AddressDTO data) {
        Address address = new Address();
        address.setCity(data.city());
        address.setNumber(data.number());
        address.setStreet(data.street());
        address.setZipCode(data.zipCode());
        return address;
    }
}
