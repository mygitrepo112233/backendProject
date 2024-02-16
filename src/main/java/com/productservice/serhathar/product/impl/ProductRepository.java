package com.productservice.serhathar.product.impl;

import com.productservice.serhathar.product.api.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Object> findByName(String name);
    List<Product> findAllByStatusTrue();
}