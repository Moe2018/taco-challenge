package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Save New Product
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Void> createNewProduct(@RequestBody Product product) {

        try {
            productService.save(product);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get Product Info by using Product Id
    @RequestMapping(value = "find/id/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable Long productId) {

        return productService.findById(productId);
    }

    // Get all Product
    @RequestMapping(value = "find/all", method = RequestMethod.GET)
    public List<Product> findAllProduct() {

        return productService.findAllProduct();
    }
}
