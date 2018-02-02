package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repo;




	@Override
	public void save(Customer customer) {
		repo.save(customer);

	}

	@Override
	public void delete(Customer customer) {
		repo.delete(customer);

	}

	@Override
	public void deleteById(Long customerId) {
		repo.delete(customerId);

	}

	@Override
	public Customer findById(Long customerId) {
		return repo.findOne(customerId);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return repo.findAll();
	}

}
