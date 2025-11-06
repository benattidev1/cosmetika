package com.cosmetika.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetika.api.mapper.ProductMapper;
import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.product.dto.CreateProductRequest;
import com.cosmetika.api.model.product.dto.ProductResponse;
import com.cosmetika.api.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("null")
    @Transactional
    public ProductResponse create(CreateProductRequest request) {
        if (request == null)
            throw new IllegalArgumentException("Request cannot be empty");

        if (productRepository.findBySku(request.getSku()).isPresent())
            throw new IllegalArgumentException("Product with this SKU already exists");

        Product product = ProductMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

}
