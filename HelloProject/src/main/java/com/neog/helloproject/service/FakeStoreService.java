package com.neog.helloproject.service;
import com.neog.helloproject.dto.ProductDto;
import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreService implements ProductService{

    private static String baseUrl = "https://fakestoreapi.com/products/";
    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate rt){
        this.restTemplate = rt;
    }

    @Override
    public List<Product> getProducts() {
        ResponseEntity<List<ProductDto>> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDto>>() {});
        List<ProductDto> products = response.getBody();
        List<Product> prods = new ArrayList<>();
        for(ProductDto prod : products){
            prods.add(prod.toProduct());
        }
        return prods;
    }

    @Override
    public Product getProductById(int id) {
        ProductDto productDto = restTemplate.getForObject(baseUrl+id, ProductDto.class);
        if(productDto == null) return new Product();
        return productDto.toProduct();
    }

    @Override
    public Product addProduct(Product product) {
        ProductDto dto = product.toProductDto();
        HttpEntity<ProductDto> request = new HttpEntity<>(dto);
        ResponseEntity<ProductDto> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.POST,
                request,
                ProductDto.class
                );
        return response.getBody().toProduct();
    }

    @Override
    public Product updateProduct(Product product) {
        ProductDto dto = product.toProductDto();
        HttpEntity<ProductDto> request = new HttpEntity<>(dto);
        ResponseEntity<ProductDto> response = restTemplate.exchange(
                baseUrl+(product.getId()),
                HttpMethod.PUT,
                request,
                ProductDto.class
        );
        return response.getBody().toProduct();
    }

    @Override
    public void deleteProduct(int id) {
        restTemplate.delete(baseUrl+id);
    }

    @Override
    public List<Category> getCategories() {
        ResponseEntity<List<String>> response = restTemplate.exchange(
                baseUrl+"categories",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {});

        List<Category> categories = new ArrayList<>();
        for (String cateName : response.getBody()){
            Category c = new Category();
            c.setDescription(cateName);
            categories.add(c);
        }
        return categories;
    }

    @Override
    public List<Product> getProductByCategory(String categoryName) {
        ResponseEntity<List<ProductDto>> response = restTemplate.exchange(
                baseUrl+"category/"+categoryName,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDto>>() {});
        
        List<ProductDto> products = response.getBody();
        List<Product> prods = new ArrayList<>();
        for(ProductDto prod : products){
            prods.add(prod.toProduct());
        }
        return prods;
    }

}
