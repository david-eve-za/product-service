package com.devlopment.productservice.models.repository;

import com.devlopment.productservice.models.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
