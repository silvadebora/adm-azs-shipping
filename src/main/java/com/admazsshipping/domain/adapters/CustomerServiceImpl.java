package com.admazsshipping.domain.adapters;

import com.admazsshipping.domain.Customer;
import com.admazsshipping.domain.ports.interfaces.CustomerServicePort;
import com.admazsshipping.domain.ports.repositories.CustomerRepositoryPort;

public class CustomerServiceImpl implements CustomerServicePort {

    private final CustomerRepositoryPort customerRepository;

    public CustomerServiceImpl(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer insert(Customer customerData) {
        return this.customerRepository.insert(customerData);
    }

    @Override
    public Customer findById(String customerId) {
        return this.customerRepository.findById(customerId);
    }
}
