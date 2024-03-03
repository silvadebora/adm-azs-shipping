package com.admazsshipping.infrastructure.adapters.services;

import com.admazsshipping.domain.Address;
import com.admazsshipping.domain.Customer;
import com.admazsshipping.domain.ports.repositories.CustomerRepositoryPort;
import com.admazsshipping.infrastructure.adapters.entities.AddressEntity;
import com.admazsshipping.infrastructure.adapters.entities.CustomerEntity;
import com.admazsshipping.infrastructure.adapters.exceptions.CustomerNotFoundException;
import com.admazsshipping.infrastructure.adapters.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceAdapterImpl implements CustomerRepositoryPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer insert(Customer customer) {
        var addressEntity = mapAddressToEntity(customer.getAddress());
        var customerEntity = mapCustomerToEntity(customer);
        customerEntity.setAddress(addressEntity);
        var customerSaved = customerRepository.save(customerEntity);
        return convertToCustomer(customerSaved);
    }

    @Override
    public Customer findById(String customerId) {
        var customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        return convertToCustomer(customer);
    }


    public AddressEntity mapAddressToEntity(Address data) {
        AddressEntity address = new AddressEntity();
        address.setCity(data.getCity());
        address.setNumber(data.getNumber());
        address.setStreet(data.getStreet());
        address.setZipCode(data.getZipCode());
        return address;
    }

    private Customer convertToCustomer(CustomerEntity entity){
        var toCustomer = entity.toCustomer();
        toCustomer.setAddress(entity.getAddress().toAddress());
        return toCustomer;
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
