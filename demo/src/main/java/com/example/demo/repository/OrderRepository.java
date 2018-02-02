package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.model.ProductOrder;

public interface OrderRepository extends JpaRepository<ProductOrder, Long> {

	
	@Query(value = "SELECT * FROM product_order WHERE customer_id = ?1", nativeQuery = true)
	List<ProductOrder> findByCustomerId(Long customerId);
}
