package com.admazsshipping.infrastructure.adapters.repositories;

import com.admazsshipping.infrastructure.adapters.entities.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<AddressEntity, String> {

}
