package com.anurag.ecommerce.controller;

import com.anurag.ecommerce.entity.Category;
import com.anurag.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> UpdateCategoryById(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategoryById(id, category);
        return ResponseEntity.ok(updatedCategory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
        String message = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(message);
    }
}
