package com.example.store.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
@Data
public class Product {

    @Id
    private ObjectId id;

    private String name;

    private String description;

    private Integer quantity;

    private Double price;
}
