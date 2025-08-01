package com.example.springcloudapp.Services;

import com.example.springcloudapp.Models.Product;

import java.util.List;

public interface ProductService {

    public Product getSingleProduct(Long id);

    public Product createProduct(String title, String description, Double price, String category, String image);

    public List<Product> getAllProducts();
}
