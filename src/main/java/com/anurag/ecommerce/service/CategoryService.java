package com.anurag.ecommerce.service;

import com.anurag.ecommerce.entity.Category;
import com.anurag.ecommerce.exception.CategoryNotFoundException;
import com.anurag.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        Category newCategory = categoryRepository.save(category);
        return newCategory;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    public Category updateCategoryById(Long id, Category category) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());
            return categoryRepository.save(existingCategory);
        } else {
            throw new CategoryNotFoundException("Category not found with id: " + id);
        }
    }

    public String deleteCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            categoryRepository.deleteById(id);
            return "Category Deleted";
        } else {
            throw new CategoryNotFoundException("Category not found with id: " + id);
        }
    }


}
