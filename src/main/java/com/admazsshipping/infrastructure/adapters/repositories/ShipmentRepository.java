package com.admazsshipping.infrastructure.adapters.repositories;

import com.admazsshipping.infrastructure.adapters.entities.ShipmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends MongoRepository<ShipmentEntity, String> {
    @Query("{$or:[{ 'origin': {$regex: ?0, $options: 'i'}}, { 'destination': {$regex: ?0, $options: 'i'}}, " +
            "{ 'loadDescription': {$regex: ?0, $options: 'i'}}, { 'weight': {$regex: ?0, $options: 'i'}}, " +
            "{ 'volume': {$regex: ?0, $options: 'i'}}, { 'cubage': {$regex: ?0, $options: 'i'}}, { 'sender': {$regex: ?0, $options: 'i'}}, " +
            "{ 'receiver': {$regex: ?0, $options: 'i'}}, { 'status': {$regex: ?0, $options: 'i'}}]}")
    Page<ShipmentEntity> findBySearchTerm(String searchTerm, Pageable pageable);
}
