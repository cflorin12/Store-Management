package com.example.store.controller;

import com.example.store.model.Product;
import com.example.store.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        productService.delete(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") ObjectId id, @RequestBody Map<String,Object> newProductFields){
        return productService.update(id,newProductFields);
    }

}
