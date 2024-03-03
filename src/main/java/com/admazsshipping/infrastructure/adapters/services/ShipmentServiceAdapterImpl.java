package com.admazsshipping.infrastructure.adapters.services.impl;

import com.admazsshipping.domain.Address;
import com.admazsshipping.domain.Customer;
import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.ports.repositories.ShipmentRepositoryPort;
import com.admazsshipping.infrastructure.adapters.entities.AddressEntity;
import com.admazsshipping.infrastructure.adapters.entities.CustomerEntity;
import com.admazsshipping.infrastructure.adapters.entities.ShipmentEntity;
import com.admazsshipping.infrastructure.adapters.entities.ShipmentStatus;
import com.admazsshipping.infrastructure.adapters.exceptions.CustomerNotFoundException;
import com.admazsshipping.infrastructure.adapters.exceptions.ShipmentNotFoundException;
import com.admazsshipping.infrastructure.adapters.repositories.AddressRepository;
import com.admazsshipping.infrastructure.adapters.repositories.CustomerRepository;
import com.admazsshipping.infrastructure.adapters.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ShipmentServiceAdapterImpl implements ShipmentRepositoryPort {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Shipment insert(Shipment shipment) {
        CustomerEntity customer = customerRepository.findById(shipment.getSender().getId()).orElseThrow(CustomerNotFoundException::new);
        ShipmentEntity shipmentEntity = mapShipmentToEntity(shipment);
        shipmentEntity.setSender(customer);
        ShipmentEntity savedShipment = shipmentRepository.save(shipmentEntity);
        return savedShipment.toShipment();
    }

    @Override
    public Page<Shipment> findShipment(String searchTerm, Pageable pageable) {
        var result = shipmentRepository.findBySearchTerm(searchTerm, pageable);
        return result.map(ShipmentEntity::toShipment);
    }

    @Override
    public Shipment findById(String shipmentId) {
        var shipmentEntity = shipmentRepository.findById(shipmentId).orElseThrow(ShipmentNotFoundException::new);
        return convertToShipment(shipmentEntity);
    }

    @Override
    public Shipment update(String id, Shipment shipment) {
        var shipmentEntity = shipmentRepository.findById(id).orElseThrow(ShipmentNotFoundException::new);
        if (shipment.getDestination() != null) shipmentEntity.setDestination(mapAddressToEntity(shipment.getDestination()));
        if(!shipment.getSender().getId().isEmpty()) customerRepository.findById(shipment.getSender().getId()).ifPresent(shipmentEntity::setSender);
        if(shipment.getCubage() != null) shipmentEntity.setCubage(shipment.getCubage());
        if(!shipment.getLoadDescription().isEmpty()) shipmentEntity.setLoadDescription(shipment.getLoadDescription());
        if(!shipment.getOrigin().isEmpty()) shipmentEntity.setOrigin(shipment.getOrigin());
        if(shipment.getWeight() != null) shipmentEntity.setWeight(shipment.getWeight());
        if(shipment.getVolume() != null) shipmentEntity.setVolume(shipment.getVolume());
        if(shipment.getStatus() != null) shipmentEntity.setStatus(ShipmentStatus.fromString(shipment.getStatus()));
        if(!shipment.getReceiver().isEmpty()) shipmentEntity.setReceiver(shipment.getReceiver());
        var save = shipmentRepository.save(shipmentEntity);
        return convertToShipment(save);
    }

    @Override
    public void delete(String id) {
        var shipment = shipmentRepository.findById(id).orElseThrow(RuntimeException::new);
        this.shipmentRepository.delete(shipment);
    }

    public Shipment convertToShipment(ShipmentEntity entity){
        var toShipment = entity.toShipmentWith(entity.getDestination());
        toShipment.setSender(entity.getSender().toCustomer());
        return toShipment;
    }

    public ShipmentEntity mapShipmentToEntity(Shipment data){
        ShipmentEntity shipment = new ShipmentEntity();
        shipment.setId(data.getId());
        shipment.setCubage(data.getCubage());
        shipment.setLoadDescription(data.getLoadDescription());
        shipment.setOrigin(data.getOrigin());
        shipment.setWeight(data.getWeight());
        shipment.setVolume(data.getVolume());
        shipment.setStatus(ShipmentStatus.fromString(data.getStatus()));
        shipment.setReceiver(data.getReceiver());
        shipment.setDestination(mapAddressToEntity(data.getDestination()));
        shipment.setSender(mapCustomerToEntity(data.getSender()));
        return shipment;
    }

    public AddressEntity mapAddressToEntity(Address data) {
        AddressEntity address = new AddressEntity();
        address.setCity(data.getCity());
        address.setNumber(data.getNumber());
        address.setStreet(data.getStreet());
        address.setZipCode(data.getZipCode());
        return address;
    }


    public CustomerEntity mapCustomerToEntity(Customer data) {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(data.getId());
        customer.setName(data.getName());
        customer.setDocumentNumber(data.getDocumentNumber());
        customer.setEmail(data.getEmail());
        customer.setPhoneNumber(data.getPhoneNumber());
        return customer;
    }

}
