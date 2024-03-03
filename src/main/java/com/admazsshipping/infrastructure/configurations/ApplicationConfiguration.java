package com.admazsshipping.infrastructure.configurations;

import com.admazsshipping.domain.adapters.CustomerServiceImpl;
import com.admazsshipping.domain.adapters.ShipmentServiceImpl;
import com.admazsshipping.domain.ports.interfaces.CustomerServicePort;
import com.admazsshipping.domain.ports.interfaces.ShipmentServicePort;
import com.admazsshipping.domain.ports.repositories.CustomerRepositoryPort;
import com.admazsshipping.domain.ports.repositories.ShipmentRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ShipmentServicePort shipmentService(ShipmentRepositoryPort shipmentRepositoryPort, CustomerRepositoryPort customerRepositoryPort){
        return new ShipmentServiceImpl(shipmentRepositoryPort, customerRepositoryPort);
    }

    @Bean
    public CustomerServicePort customerService(CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerServiceImpl(customerRepositoryPort);
    }

}
