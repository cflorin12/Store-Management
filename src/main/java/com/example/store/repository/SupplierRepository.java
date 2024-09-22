package com.example.store.repository;

import com.example.store.model.Supplier;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupplierRepository extends MongoRepository<Supplier, ObjectId> {
    List<Supplier> findByIsActive(Boolean isActive);
}
