package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;


    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void delete(Product product) {
        repo.delete(product);
    }

    @Override
    public void deleteById(Long productId) {
        repo.delete(productId);
    }

    @Override
    public Product findById(Long productId) {
        return repo.findOne(productId);
    }

    @Override
    public List<Product> findAllProduct() {
        return repo.findAll();
    }
}
