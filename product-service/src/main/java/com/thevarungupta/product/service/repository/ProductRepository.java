package com.thevarungupta.product.service.repository;

import com.thevarungupta.product.service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
