package com.devlopment.productservice.services;

import com.devlopment.productservice.models.entitys.Product;
import com.devlopment.productservice.models.repository.IProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable("products")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "product")
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    @Caching(evict = {
            @CacheEvict(value = "products"),
            @CacheEvict(value = "product")
    })
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "products"),
            @CacheEvict(value = "product")
    })
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
