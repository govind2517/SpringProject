package com.neog.paymentservice.repos;

import com.neog.paymentservice.model.Product;
import org.hibernate.query.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
