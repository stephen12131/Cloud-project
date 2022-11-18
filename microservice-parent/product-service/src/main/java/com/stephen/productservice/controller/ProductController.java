package com.stephen.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.stephen.productservice.dto.ProductRequest;
import com.stephen.productservice.dto.ProductResponse;
import com.stephen.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    
	/* inject product service via constructor injection */
	private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//spring framework imports
    public void createProduct(@RequestBody ProductRequest productRequest) {
    	 productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}