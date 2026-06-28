package com.anurag.ecommerce.repository;

import com.anurag.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
