package com.neog.paymentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class Product {

    @Id
    private int id;
    private String name, alias, shortDescription, mainImage;
    private boolean isEnabled, inStock;

}
