package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product_order")
public class ProductOrder {
	
	@Column(name = "order_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name = "customer_id", nullable = false)
	private Long customerId;
	
	@Column(name = "number_of_tacos", nullable = false)
	private int numberOfTacos;
	
	@Column(name = "total_order", nullable = false)
	private double totalOrder;

	public Long getOrderId() {

		return orderId;
	}

	public void setOrderId(Long orderId) {


		this.orderId = orderId;
	}

	public Long getCustomerId() {

		return customerId;
	}

	public void setCustomerId(Long customerId) {

		this.customerId = customerId;
	}

	public int getNumberOfTacos() {

		return numberOfTacos;
	}

	public void setNumberOfTacos(int numberOfTacos) {

		this.numberOfTacos = numberOfTacos;
	}

	public double getTotalOrder() {

		return totalOrder;
	}

	public void setTotalOrder(double totalOrder) {

		this.totalOrder = totalOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOrder other = (ProductOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", numberOfTacos=" + numberOfTacos
				+ ", totalOrder=" + totalOrder + "]";
	}
	
	
	
	
	

}
