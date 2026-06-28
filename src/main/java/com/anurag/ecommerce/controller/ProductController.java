package com.anurag.ecommerce.controller;

import com.anurag.ecommerce.dto.ProductResponseDTO;
import com.anurag.ecommerce.entity.Product;
import com.anurag.ecommerce.mapper.ProductMapper;
import com.anurag.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createdProduct(@Valid @RequestBody Product product) {
        Product createProduct = productService.createProduct(product);
        ProductResponseDTO createdProductDTO = ProductMapper.toDTO(createProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPage = productService.getAllProducts(pageable);

        List<Product> products = productPage.getContent();

        List<ProductResponseDTO> dtoList = new ArrayList<>();

        for (Product product : products) {
            dtoList.add(ProductMapper.toDTO(product));
        }

        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        Product obtainedProduct = productService.getProductById(id);
        ProductResponseDTO obtainedProductNew = ProductMapper.toDTO(obtainedProduct);
        return ResponseEntity.ok(obtainedProductNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(@PathVariable Long id, @Valid @RequestBody Product product) {
        Product obtainedProduct = productService.updateProductById(id, product);
        ProductResponseDTO obtainedProductNew = ProductMapper.toDTO(obtainedProduct);
        return ResponseEntity.ok(obtainedProductNew);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id) {
        String message = productService.deleteProductById(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<ProductResponseDTO>> getSortedProducts(@RequestParam String field) {
        List<Product> products = productService.getAllProductsSorted(field);
        List<ProductResponseDTO> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(ProductMapper.toDTO(product));
        }
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> getProductByName(@RequestParam String name) {
        List<Product> products = productService.getProductsByName(name);
        List<ProductResponseDTO> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(ProductMapper.toDTO(product));
        }
        return ResponseEntity.ok(dtoList);
    }

}
