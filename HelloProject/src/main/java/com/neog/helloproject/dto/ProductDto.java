package com.neog.helloproject.dto;

import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String title, description, category, image;
    private double price;

    public Product toProduct() {
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setDescription(description);
        p.setImageUrl(image);
        p.setPrice(price);
        Category cate = new Category();
        cate.setDescription(category);
        p.setCategory(cate);
        return p;
    }
}