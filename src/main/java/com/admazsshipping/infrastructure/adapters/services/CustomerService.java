package com.admazsshipping.infrastructure.adapters.services;

import com.admazsshipping.domain.Address;
import com.admazsshipping.domain.Customer;
import com.admazsshipping.infrastructure.adapters.entities.AddressEntity;
import com.admazsshipping.infrastructure.adapters.entities.CustomerEntity;

public interface CustomerService {

    void insert(Customer customer);

    AddressEntity mapAddressToEntity(Address data);

    CustomerEntity mapCustomerToEntity(Customer data);
}
