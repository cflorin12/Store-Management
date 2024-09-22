package com.example.store.service;

import com.example.store.model.Address;
import com.example.store.model.Supplier;
import com.example.store.model.Supplier;
import com.example.store.repository.SupplierRepository;
import com.example.store.repository.SupplierRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(Boolean isActive){
        if(isActive == null)
            return supplierRepository.findAll();
        return supplierRepository.findByIsActive(isActive);
    }

    public Supplier getSupplierById(String id){
        ObjectId objectId = new ObjectId(id);
        Optional<Supplier> supplier = supplierRepository.findById(objectId);
        if(supplier.isPresent())
            return supplier.get();
        else throw new IllegalArgumentException("Supplier with id " + id + " does not exist");
    }

    public Supplier addSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void delete(String id) {
        ObjectId objectId = new ObjectId(id);
        if (!supplierRepository.existsById(objectId)) {
            throw new IllegalArgumentException("Supplier with id " + id + " does not exist");
        }
        makeSupplierInactive(objectId);
    }

    private void makeSupplierInactive(ObjectId id){
        Supplier supplier = supplierRepository.findById(id).get();
        supplier.setIsActive(false);
        supplierRepository.save(supplier);
    }

    public Supplier update(ObjectId id, Supplier newSupplier){
        Supplier existingSupplier = supplierRepository.findById(id).orElseThrow();
        if (newSupplier.getName() != null) {
            existingSupplier.setName(newSupplier.getName());
        }
        if (newSupplier.getPhoneNumber() != null) {
            existingSupplier.setPhoneNumber(newSupplier.getPhoneNumber());
        }
        if (newSupplier.getEmail() != null) {
            existingSupplier.setEmail(newSupplier.getEmail());
        }
        if (newSupplier.getIsActive() != null) {
            existingSupplier.setIsActive(newSupplier.getIsActive());
        }
        if (newSupplier.getAddress() != null) {
            if (newSupplier.getAddress().getStreet() != null) {
                existingSupplier.getAddress().setStreet(newSupplier.getAddress().getStreet());
            }
            if (newSupplier.getAddress().getCity() != null) {
                existingSupplier.getAddress().setCity(newSupplier.getAddress().getCity());
            }
            if (newSupplier.getAddress().getCountry() != null) {
                existingSupplier.getAddress().setCountry(newSupplier.getAddress().getCountry());
            }
        }
        return supplierRepository.save(existingSupplier);
    }
}
