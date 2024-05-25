package com.neog.helloproject.service;

import com.neog.helloproject.exceptions.ProductNotFoundException;
import com.neog.helloproject.model.Category;
import com.neog.helloproject.model.Product;
import com.neog.helloproject.repository.CategoryRepository;
import com.neog.helloproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private Product isValidProductId(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional =  productRepository.findById(id);
        if(productOptional.isPresent())
            return productOptional.get();
        else
            throw new ProductNotFoundException("Product not exist, invalid product id.");
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        return isValidProductId(Long.valueOf(id));
    }

    @Override
    public Product addProduct(Product product) {
        // Before saving product we need to check for Category
        Category category =  categoryRepository.findByCode(product.getCategory().getCode());
        System.out.println("here "+category);
        if(category == null){
            // create category as it is new
            category = categoryRepository.save(product.getCategory());
            product.setCategory(category);
        }else{
            product.setCategory(category);
        }
        System.out.println("here "+category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        isValidProductId(product.getId());
        // Before updating product we need to check for Category
        Category category =  categoryRepository.findByCode(product.getCategory().getCode());
        System.out.println("here "+category);
        if(category == null){
            // create category as it is new
            category = categoryRepository.save(product.getCategory());
            product.setCategory(category);
        }else{
            product.setCategory(category);
        }
        System.out.println("here "+category);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) throws ProductNotFoundException {
        isValidProductId(Long.valueOf(id));
        productRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<Category> getCategories() {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(String categoryName) {
        return List.of();
    }
}
