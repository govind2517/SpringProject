package com.neog.helloproject.model;

import com.neog.helloproject.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String title, description, imageUrl;
    private double price;
    private Category category;

    public ProductDto toProductDto() {
        ProductDto dto = new ProductDto();
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setImage(imageUrl);
        dto.setCategory(category.getDescription());
        return dto;
    }
}