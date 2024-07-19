package com.rushi.service;

import com.rushi.dto.PurchaseRequest;
import com.rushi.dto.PurchaseResponse;

public interface OrderService {
	
	public PurchaseResponse placeOrder(PurchaseRequest purchaseRequest)throws Exception;

}
