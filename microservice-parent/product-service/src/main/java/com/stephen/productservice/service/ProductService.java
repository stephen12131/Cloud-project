package com.stephen.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stephen.productservice.dto.ProductRequest;
import com.stephen.productservice.dto.ProductResponse;
import com.stephen.productservice.model.Product;
import com.stephen.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor /* it will automatically generate required constructor */
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

	/* here we use constructor injection */
    public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()/* to build the product object (build() method) */
				.id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
    
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }
    
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
