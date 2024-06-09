package com.neog.paymentservice.controllers;

import com.neog.paymentservice.model.Product;
import com.neog.paymentservice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {


    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/products")
    public Page<Product> getProductList(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortOrder){
        if(page == null || pageSize == null) // means not coming, then by default setting it to 10
        {
            page = 0;
            pageSize = 10;
        }
        if(sortBy == null) {
            sortBy = "name";
            sortOrder = "asc";
        }
        return service.getAllProducts(page, pageSize, sortBy, sortOrder);
    }

}
