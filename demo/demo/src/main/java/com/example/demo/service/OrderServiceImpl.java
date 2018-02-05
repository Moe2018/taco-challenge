package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ProductOrder;
import com.example.demo.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	

	@Override
	public void save(ProductOrder order) {
		repo.save(order);

	}

	@Override
	public void delete(ProductOrder order) {
		repo.delete(order);

	}

	@Override
	public void deleteById(Long orderId) {
		repo.delete(orderId);

	}

	@Override
	public ProductOrder findById(Long orderId) {
		return repo.findOne(orderId);
	}

	@Override
	public List<ProductOrder> findByCustomerId(Long customerId) {
		return repo.findByCustomerId(customerId);
	}

	@Override
	public List<ProductOrder> findAllOrder() {
		return repo.findAll();
	}

}
