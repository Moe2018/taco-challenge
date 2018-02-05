package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
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

import com.example.demo.model.ProductOrder;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {


	
	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	// Save New Order
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ResponseEntity<Void> createNewOrder(@RequestBody ProductOrder order) {
		
		//logger.info("ORDER IS : "+order);

		ProductOrder currentOrder = new ProductOrder();
		currentOrder.setCustomerId(order.getCustomerId());
		currentOrder.setNumberOfTacos(order.getNumberOfTacos());

		Product currentProduct = productService.findById(new Long(1));

		int totalProductCount = currentOrder.getNumberOfTacos();
		double productPrice = currentProduct.getProductPrice();

		currentOrder.setTotalOrder(totalProductCount*productPrice);

		try {
			orderService.save(currentOrder);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	// Get all Order for a Customer By using Customer Id
	@RequestMapping(value = "find/customerId/{customerId}", method = RequestMethod.GET)
	public List<ProductOrder> getAllOrdersForCustomer(@PathVariable Long customerId) {
		return orderService.findByCustomerId(customerId);
	}

	// Get all Order for all
	@RequestMapping(value = "find/all", method = RequestMethod.GET)
	public List<ProductOrder> findAllOrders() {
		return orderService.findAllOrder();
	}

}
