# 🛒 E-Commerce Backend API

## Project Overview

# 🛒 E-Commerce Backend API

A RESTful backend application built using Spring Boot for managing products and categories in an e-commerce system.

The project demonstrates modern backend development practices including layered architecture, Spring Data JPA, Hibernate ORM, RESTful API design, DTO mapping, request validation, global exception handling, pagination, sorting, searching, and interactive API documentation using Swagger/OpenAPI.

The application follows a clean Controller → Service → Repository architecture, making the code modular, maintainable, and easy to extend.

## ✨ Features

### 📦 Product Management
- Create Product
- Get All Products
- Get Product by ID
- Update Product
- Delete Product
- Search Products by Name
- Sort Products
- Pagination Support

### 🗂️ Category Management
- Create Category
- Get All Categories
- Get Category by ID
- Update Category
- Delete Category

### ⚙️ Backend Features
- RESTful API Design
- Layered Architecture
- Spring Data JPA
- Hibernate ORM
- DTO Mapping
- Manual Mapper Implementation
- Bean Validation
- Global Exception Handling
- Swagger/OpenAPI Documentation

## 🛠️ Technology Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Swagger / OpenAPI
- Git
- GitHub


## 🏗️ Project Architecture

The project follows a layered architecture.

```
                Client
                   │
                   ▼
          REST Controller
                   │
                   ▼
             Service Layer
                   │
                   ▼
          Repository Layer
                   │
                   ▼
             MySQL Database
```

### Layers

- **Controller** – Handles HTTP requests and responses.
- **Service** – Contains the business logic.
- **Repository** – Performs database operations using Spring Data JPA.
- **Entity** – Represents database tables.
- **DTO** – Transfers data between client and server.
- **Mapper** – Converts Entity objects into DTOs.

## 🗄️ Database Design

### Category

| Column | Type |
|---------|------|
| id | Long |
| name | String |
| description | String |

### Product

| Column | Type |
|---------|------|
| id | Long |
| name | String |
| description | String |
| price | Double |
| stockQuantity | Integer |
| category_id | Long |

### Relationship

One Category → Many Products

Many Products → One Category

## 📂 Project Structure

```
src
└── main
    ├── java
    │   └── com.anurag.ecommerce
    │       ├── controller
    │       ├── service
    │       ├── repository
    │       ├── entity
    │       ├── dto
    │       ├── mapper
    │       ├── exception
    │       └── EcommerceApplication.java
    │
    └── resources
        └── application.properties
```


## 🌐 REST API Endpoints

### Category APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/categories` | Create a new category |
| GET | `/categories` | Get all categories |
| GET | `/categories/{id}` | Get category by ID |
| PUT | `/categories/{id}` | Update category |
| DELETE | `/categories/{id}` | Delete category |

### Product APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/products` | Create a new product |
| GET | `/products` | Get all products (Pagination Supported) |
| GET | `/products/{id}` | Get product by ID |
| PUT | `/products/{id}` | Update product |
| DELETE | `/products/{id}` | Delete product |
| GET | `/products/search?name=` | Search products by name |
| GET | `/products/sorted?field=` | Sort products by any field |

## ✅ Validation

The application validates incoming requests using Jakarta Bean Validation.

Implemented validations include:

- Product name cannot be blank.
- Product description cannot be blank.
- Price must be positive.
- Stock quantity cannot be negative.
- Request validation using `@Valid`.


## ⚠️ Exception Handling

The project implements centralized exception handling using `@ControllerAdvice`.

### Custom Exceptions

- ProductNotFoundException
- CategoryNotFoundException

### Global Exception Handler

A global exception handler returns meaningful HTTP responses instead of exposing internal server errors.

Example:

```
404 Not Found

{
    "message": "Product not found with id: 10"
}
```

## 📖 Swagger Documentation

Swagger/OpenAPI has been integrated to provide interactive API documentation.

After running the application locally, Swagger UI can be accessed at:

```
http://localhost:8080/swagger-ui/index.html
```

After deployment, this section will be updated with the live Swagger URL.


## ⚙️ Running the Project

### Prerequisites

- Java 21
- Maven
- MySQL

### Steps

1. Clone the repository.

```
git clone https://github.com/anurag-IITgn/ecommerce-api.git
```

2. Create a MySQL database.

```
CREATE DATABASE ecommerce_db;
```

3. Configure database credentials in:

```
src/main/resources/application.properties
```

4. Run the application.

```
mvn spring-boot:run
```

5. Open Swagger UI.

```
http://localhost:8080/swagger-ui/index.html
```

## 🔮 Future Improvements

The following features can be added to extend the project:

- Spring Security
- JWT Authentication
- Role-Based Access Control (RBAC)
- Docker Containerization
- Unit Testing
- Integration Testing
- Logging Framework
- Redis Caching
- Product Image Upload
- Order Management
- User Management

## 👨‍💻 Author : Anurag
- GitHub: https://github.com/anurag-IITgn