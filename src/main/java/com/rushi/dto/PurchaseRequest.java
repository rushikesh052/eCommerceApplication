package com.rushi.dto;

import java.util.Set;

import com.rushi.entity.Address;
import com.rushi.entity.Customer;
import com.rushi.entity.Order;
import com.rushi.entity.OrderItem;

public class PurchaseRequest {
	
	private Customer customer;
	private Address shippingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
