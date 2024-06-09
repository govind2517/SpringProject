package com.neog.paymentservice.service;

import com.neog.paymentservice.model.Product;
import com.neog.paymentservice.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository repo;

    public Page<Product> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortObj = Sort.by(sortBy);
        if("asc".equals(sortOrder))
            sortObj.ascending();
        else
            sortObj.descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortObj);
        Page<Product> all = repo.findAll(pageable);
        return all;
    }
}
