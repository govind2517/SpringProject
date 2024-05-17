package com.neog.helloproject.service;

import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public Product getProductById(int id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int id);

    public List<Category> getCategories();
    public List<Product> getProductByCategory(String categoryName);
}
