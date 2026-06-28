package com.anurag.ecommerce.repository;

import com.anurag.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
