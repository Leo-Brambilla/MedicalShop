package com.leobrambilla.medicalshop.repositories;

import com.leobrambilla.medicalshop.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}