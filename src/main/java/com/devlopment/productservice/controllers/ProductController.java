package com.devlopment.productservice.controllers;

import com.devlopment.productservice.models.entitys.Product;
import com.devlopment.productservice.services.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/list")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/show/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }
}
