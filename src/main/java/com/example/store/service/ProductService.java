package com.example.store.service;

import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void delete(String id) {
        ObjectId objectId = new ObjectId(id);
        if (!productRepository.existsById(objectId)) {
            throw new IllegalArgumentException("Product with id " + id + " does not exist");
        }
        productRepository.deleteById(objectId);
    }

    public Product update(ObjectId id, Map<String,Object> newData){
        Product existingProduct = productRepository.findById(id).orElseThrow();
        newData.forEach((key,value) ->{
            switch (key){
                case "name":
                    existingProduct.setName((String) value);
                    break;
                case "description":
                    existingProduct.setDescription((String) value);
                    break;
                case "quantity":
                    existingProduct.setQuantity((Integer) value);
                    break;
                case "price":
                    if(value instanceof Integer) {
                        existingProduct.setPrice(((Integer) value).doubleValue());
                    } else {
                        existingProduct.setPrice((Double) value);
                    }
                    break;
            }
        });
        return productRepository.save(existingProduct);
    }
}
