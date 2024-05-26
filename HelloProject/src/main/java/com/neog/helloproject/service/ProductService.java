package com.neog.helloproject.service;

import com.neog.helloproject.exceptions.ProductNotFoundException;
import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public Product getProductById(int id) throws ProductNotFoundException;
    public Product addProduct(Product product);
    public Product updateProduct(Product product) throws ProductNotFoundException;
    public void deleteProduct(int id) throws ProductNotFoundException;

    public List<String> getCategories();
    public List<Product> getProductByCategory(String categoryName);
}
