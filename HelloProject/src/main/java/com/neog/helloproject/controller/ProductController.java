package com.neog.helloproject.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neog.helloproject.dto.ResponseDTO;
import com.neog.helloproject.exceptions.ProductNotFoundException;
import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;
import com.neog.helloproject.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController extends MasterController {

    private ProductService productService;

    private ObjectMapper mapper = new ObjectMapper();

    public ProductController(@Qualifier("productServiceImpl") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseDTO getProducts(HttpServletRequest request){
        List<Product> products = productService.getProducts();
        return generateResponse(request, mapper.convertValue(products, JsonNode.class).toString());
    }

    @GetMapping("/products/{id}")
    public ResponseDTO getProductById(HttpServletRequest request, @PathVariable int id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return generateResponse(request, mapper.convertValue(product, JsonNode.class).toString());
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
    public ResponseDTO getCategories(HttpServletRequest request){
        List<Category> categories = productService.getCategories();
        return generateResponse(request, mapper.convertValue(categories, JsonNode.class).toString());
    }

    @GetMapping("/products/categories/{categoryName}")
    public ResponseDTO getProductByCatgory(HttpServletRequest request, @PathVariable String categoryName){
        List<Product> products = productService.getProductByCategory(categoryName);
        return generateResponse(request, mapper.convertValue(products, JsonNode.class).toString());
    }
}
