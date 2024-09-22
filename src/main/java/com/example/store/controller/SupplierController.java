package com.example.store.controller;

import com.example.store.model.Supplier;
import com.example.store.model.Supplier;
import com.example.store.service.SupplierService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSuppliers(@RequestParam(required = false) Boolean isActive){
        List<Supplier> suppliers;
        return supplierService.getSuppliers(isActive);
    }

    @GetMapping("/{id}")
    public Supplier getSupplierByID(@PathVariable("id") String id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable("id") String id){
        supplierService.delete(id);
    }

    @PatchMapping("/{id}")
    public Supplier updateSupplier(@PathVariable("id") ObjectId id, @RequestBody Supplier newSupplier){
        return supplierService.update(id,newSupplier);
    }
}
