package com.admazsshipping.infrastructure.adapters.repositories;

import com.admazsshipping.infrastructure.adapters.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}
