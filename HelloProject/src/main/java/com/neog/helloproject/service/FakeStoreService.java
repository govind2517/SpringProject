package com.neog.helloproject.service;
import com.neog.helloproject.dto.ProductDto;
import com.neog.helloproject.exceptions.ProductNotFoundException;
import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
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
    private RedisTemplate redisTemplate;

    public FakeStoreService(RestTemplate rt, RedisTemplate redisTemplate) {
        this.restTemplate = rt;
        this.redisTemplate = redisTemplate;
    }

    // this can be changed to function check in db for id exist or not
    private void checkId(Long id) throws ProductNotFoundException {
        if(id > 20)
            throw new ProductNotFoundException("Product details not exists in db");
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
    public Product getProductById(int id) throws ProductNotFoundException {
        checkId(Long.valueOf(id));

        Product productFromRedis = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PROD_"+id);
        if(productFromRedis!=null){
            return productFromRedis;
        }

        ProductDto productDto = restTemplate.getForObject(baseUrl+id, ProductDto.class);
        if(productDto == null) throw new ProductNotFoundException("Product details not found.");
        Product product = productDto.toProduct();
        redisTemplate.opsForHash().put("PRODUCTS", "PROD_"+id, product);
        return product;
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
    public Product updateProduct(Product product) throws ProductNotFoundException {
        checkId(product.getId());
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
    public void deleteProduct(int id) throws ProductNotFoundException {
        checkId(Long.valueOf(id));
        restTemplate.delete(baseUrl+id);
    }

    @Override
    public List<String> getCategories() {
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
        return List.of();
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
