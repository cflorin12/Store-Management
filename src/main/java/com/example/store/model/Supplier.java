package com.example.store.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="suppliers")
@Data
public class Supplier {

    @Id
    private ObjectId id;

    private String name;

    private Address address;

    private String phoneNumber;

    private String email;

    private Boolean isActive = true;
}
