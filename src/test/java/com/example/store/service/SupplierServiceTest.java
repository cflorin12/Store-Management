package com.example.store.service;

import com.example.store.model.Supplier;
import com.example.store.repository.SupplierRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SupplierServiceTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierService supplierService;

    private ObjectId supplierId;
    private Supplier supplier;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        supplier = new Supplier();
        supplierId = new ObjectId();
        supplier.setId(supplierId);
        supplier.setName("Name");
    }

    @Test
    public void testDeleteSupplier_SUCCESS() {
        // Given
        Mockito.when(supplierRepository.findById(Mockito.any())).thenReturn(Optional.of(supplier));
        Mockito.when(supplierRepository.existsById(Mockito.any())).thenReturn(true);
        Mockito.when(supplierRepository.save(Mockito.any())).thenReturn(supplier);

        // When
        Supplier newSupplier = supplierService.delete(supplierId.toHexString());

        // Then
        assertEquals(false,newSupplier.getIsActive());
        Mockito.verify(supplierRepository).save(supplier);
    }

    @Test
    public void testDeleteSupplier_FAIL() {
        // Given
        Mockito.when(supplierRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(supplierRepository.existsById(Mockito.any())).thenReturn(false);

        // When
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                supplierService.delete(new ObjectId().toHexString()));

        // Then
        Mockito.verify(supplierRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    public void testUpdateSupplier() {
        // Given
        Mockito.when(supplierRepository.findById(Mockito.any())).thenReturn(Optional.of(supplier));
        Supplier newSupplier = new Supplier();
        newSupplier.setName("New Name");
        Mockito.when(supplierRepository.save(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        newSupplier = supplierService.update(supplierId,newSupplier);

        // Then
        assertEquals(newSupplier.getName(),"New Name");
    }
}