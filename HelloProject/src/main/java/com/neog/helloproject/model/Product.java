package com.neog.helloproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neog.helloproject.dto.ProductDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel{
    private String title, description, imageUrl;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
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