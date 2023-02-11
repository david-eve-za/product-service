package com.devlopment.productservice.services;

import com.devlopment.productservice.models.entitys.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public Product save(Product product);
    public void delete(Long id);
}
