package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
	
	

	@Autowired
	private CustomerService customerService;

	// Save New Customer
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ResponseEntity<Void> createNewCustomer(@RequestBody Customer customer) {
		
		try {
			customerService.save(customer);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	// Get Customer Profile By Using Customer Id
	@RequestMapping(value = "find/id/{customerId}", method = RequestMethod.GET)
	public Customer getCustomerProfileById(@PathVariable Long customerId) {

		return customerService.findById(customerId);
	}

	// Get all Customer
	@RequestMapping(value = "find/all", method = RequestMethod.GET)
	public List<Customer> findAllCustomer() {

		return customerService.findAllCustomer();
	}

}
