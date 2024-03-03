package com.admazsshipping.domain.ports.interfaces;

import com.admazsshipping.domain.Customer;

public interface CustomerServicePort {

    Customer insert(Customer customerData);
    Customer findById(String customerId);
}
