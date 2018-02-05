package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    void delete(Product product);

    void deleteById(Long productId);

    Product findById(Long productId);

    List<Product> findAllProduct();


}
