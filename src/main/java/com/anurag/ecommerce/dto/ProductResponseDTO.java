package com.anurag.ecommerce.dto;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private String categoryName;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Long id, String categoryName, Integer stockQuantity, Double price, String name, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
