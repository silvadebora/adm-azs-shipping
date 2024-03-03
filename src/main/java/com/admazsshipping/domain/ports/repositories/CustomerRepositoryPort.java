package com.admazsshipping.domain.ports.repositories;

import com.admazsshipping.domain.Customer;

public interface CustomerRepositoryPort {

    Customer insert(Customer customer);
    Customer findById(String customerId);
}
