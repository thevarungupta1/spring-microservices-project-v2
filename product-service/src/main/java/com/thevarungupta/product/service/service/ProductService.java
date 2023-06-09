package com.thevarungupta.product.service.service;

import com.thevarungupta.product.service.entity.Product;
import com.thevarungupta.product.service.model.ProductRequest;
import com.thevarungupta.product.service.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductResponse addProduct(ProductRequest product);
    ProductResponse getProductById(Long productId);
    void reduceQuantity(long productId, long quantity);
}
