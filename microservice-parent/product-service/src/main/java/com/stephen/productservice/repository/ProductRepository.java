package com.stephen.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephen.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product,String>{

}
