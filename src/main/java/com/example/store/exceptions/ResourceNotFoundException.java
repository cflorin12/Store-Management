package com.example.store.exceptions;

import com.example.store.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceNotFoundException extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);
    public ResourceNotFoundException(String message) {
        super(message);
        logger.error(message);
    }
}
