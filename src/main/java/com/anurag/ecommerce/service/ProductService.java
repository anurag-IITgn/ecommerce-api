package com.anurag.ecommerce.service;

import com.anurag.ecommerce.entity.Category;
import com.anurag.ecommerce.entity.Product;
import com.anurag.ecommerce.exception.CategoryNotFoundException;
import com.anurag.ecommerce.exception.ProductNotFoundException;
import com.anurag.ecommerce.repository.CategoryRepository;
import com.anurag.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product) {
        Long categoryId = product.getCategory().getId();
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            product.setCategory(existingCategory);
            return productRepository.save(product);
        } else {
            throw new CategoryNotFoundException("Category not found with id: " + categoryId);
        }

    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        Optional<Product> obtainedProduct = productRepository.findById(id);
        if (obtainedProduct.isPresent()) {
            return obtainedProduct.get();
        } else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    public Product updateProductById(Long id, Product product) {
        Optional<Product> obtainedProduct = productRepository.findById(id);
        if (obtainedProduct.isPresent()) {
            Product updatedProduct = obtainedProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setStockQuantity(product.getStockQuantity());
            updatedProduct.setCategory(product.getCategory());
            return productRepository.save(updatedProduct);
        } else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    public String deleteProductById(Long id) {
        Optional<Product> obtainedProduct = productRepository.findById(id);
        if (obtainedProduct.isPresent()) {
            productRepository.deleteById(id);
            return "Product Deleted";
        } else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    public List<Product> getAllProductsSorted(String field) {
        return productRepository.findAll(Sort.by(field));
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

}
