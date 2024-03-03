package com.admazsshipping.infrastructure.adapters.services;

import com.admazsshipping.domain.Address;
import com.admazsshipping.domain.Customer;
import com.admazsshipping.domain.Shipment;
import com.admazsshipping.infrastructure.adapters.entities.AddressEntity;
import com.admazsshipping.infrastructure.adapters.entities.CustomerEntity;
import com.admazsshipping.infrastructure.adapters.entities.ShipmentEntity;
import org.springframework.data.domain.Page;

public interface ShipmentService {

    ShipmentEntity insert(Shipment shipment);

    Page<ShipmentEntity> findShipment(String customerId, int page, int size);

    ShipmentEntity update(String id, Shipment shipment);

    void delete(String id);

    AddressEntity mapAddressToEntity(Address address);

    CustomerEntity mapCustomerToEntity(Customer customer);

}
