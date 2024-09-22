# Store Management System

## Overview
This application serves as an API designed for the management of a store

## Features
**Product Management** - APIs for adding, updating and deleting a product

**Supplier Management** - APIs for adding, updating and deleting (making inactive) a supplier

**Authentication System and Role-Based Access Control** - Secure the APIs, Product to be available to USER role and Supplier to ADMIN role

**Error handling and logging** - Error handling for invalid requests and logging the requests for monitoring

**MongoDB Integration** - The data is stored in a MongoDB database

## Technologies Used
- **Java 17**
- **Spring Boot**: For building the RESTful API.
- **Spring Security**: For authentication and authorization.
- **MongoDB**: For the database.
- **Mockito**: For unit testing.
- **Postman**: For testing APIs.

## How To Install and Prepare the Project
**1.** Clone the repository

**2.** Prepare your MongoDB environment (set up a database, create username)

**3.** Create an **.env** file inside the **resources** folder to contain the data related to the database (user, password, cluster), matching the content from **application.properties**

## API Documentation
### Suppliers
**GET /suppliers:** Retrieve all suppliers.
    
  - **Request Parameter** - _**isActive**_ (optional) Filter suppliers based on this field
    
**POST /suppliers:** Add a new supplier.
    
  - **Request Body** - Supplier details 
    
**GET /suppliers/{id}:** Retrieve a specific supplier by ID.

**PUT /suppliers/{id}:** Update a specific supplier.
  - **Request Body** - The fields that will be updated

**DELETE /suppliers/{id}:** Makes a supplier to appear as inactive.
### Products
**POST /products:** Add a new product.

  - **Request Body** - Product details

**PUT /products/{id}:** Update a specific product.
    
  - **Request Body** - The fields that will be updated
    
**DELETE /products/{id}:** Delete a specific product.

## Role-Based Access
- Admins can access all endpoints
- Users can access only endpoints related to products

## How To Test
**1.** Run the application

**2.** Open Postman

**3.** Go to "Authorization"

**4.** Select "Basic Auth" type

**5.** Write the username and password (which can be found inside the SecurityConfig class)

**6.** Send the request
