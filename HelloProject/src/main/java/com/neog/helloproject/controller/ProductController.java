package com.neog.helloproject.controller;

import com.neog.helloproject.exceptions.ProductNotFoundException;
import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;
import com.neog.helloproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return product;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        product = productService.addProduct(product);
        return product;
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) throws ProductNotFoundException {
        product = productService.updateProduct(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }

    // Categories

    @GetMapping("/products/categories")
    public List<Category> getCategories(){
        List<Category> categories = productService.getCategories();
        return categories;
    }

    @GetMapping("/products/categories/{categoryName}")
    public List<Product> getProductByCatgory(@PathVariable String categoryName){
        List<Product> products = productService.getProductByCategory(categoryName);
        return products;
    }
}
