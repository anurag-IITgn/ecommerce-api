package com.anurag.ecommerce.mapper;

import com.anurag.ecommerce.dto.ProductResponseDTO;
import com.anurag.ecommerce.entity.Product;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }


}
