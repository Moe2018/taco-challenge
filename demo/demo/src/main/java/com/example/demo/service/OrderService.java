package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductOrder;

public interface OrderService {
	
	void save(ProductOrder order);
	
	void delete(ProductOrder order);
	
	void deleteById(Long orderId);
	
	ProductOrder findById(Long orderId);
	
	List<ProductOrder> findByCustomerId(Long customerId);
	
	List<ProductOrder> findAllOrder();

}
