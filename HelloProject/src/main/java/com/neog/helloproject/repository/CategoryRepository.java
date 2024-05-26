package com.neog.helloproject.repository;

import com.neog.helloproject.model.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByCode(String code);

    // using HQL here
    @Query("SELECT c.code FROM Category c")
    public List<String> findAllCategoriesCode();

}
