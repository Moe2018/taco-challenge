package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;


public interface CustomerService {
	
	void save(Customer customer);
	
	void delete(Customer customer);
	
	void deleteById(Long customerId);
	
	Customer findById(Long customerId);
	
	List<Customer> findAllCustomer();
	
	
	
	

}
