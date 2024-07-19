package com.rushi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushi.dto.PurchaseRequest;
import com.rushi.dto.PurchaseResponse;
import com.rushi.service.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderService orderService; 
	
	@PostMapping("/purchase")
	public PurchaseResponse createOrder(@RequestBody PurchaseRequest purchaseRequest)throws Exception {
		return orderService.placeOrder(purchaseRequest);
	}
	
	
	

}
