package com.rushi.service;

import java.util.Set;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.rushi.dto.PurchaseRequest;
import com.rushi.dto.PurchaseResponse;
import com.rushi.entity.Customer;
import com.rushi.entity.Order;
import com.rushi.entity.OrderItem;
import com.rushi.repository.CustomerRepository;


@Service
public class OrderServiceImpl implements OrderService {
	
	
	private String keyId="rzp_test_6velCtDaXRLUzt";
	
	private String keySecret="R2j6G4u3ZMbV0twaVIFORBm2";

	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	@Override
	public PurchaseResponse placeOrder(PurchaseRequest purchaseRequest)throws Exception {
		
		Order order = purchaseRequest.getOrder();
		String orderTrackingNumber = UUID.randomUUID().toString();
		order.setOrderTrackingNumber(orderTrackingNumber);
		order.setStatus("PENDING");
		
		Set<OrderItem> orderItems = purchaseRequest.getOrderItems();
		orderItems.forEach( item ->order.add(item));
	
		
		order.setShippingAddress(purchaseRequest.getShippingAddress());
		
		Customer customer = purchaseRequest.getCustomer();
		String email = customer.getEmail();
		
		
		Customer customerFromDb = customerRepository.findByEmail(email);
		if(customerFromDb!=null) {
			customer = customerFromDb;
		}
		customer.add(order);
		//save customer in  db
		customerRepository.save(customer);
		
		String razorpayOrderId = createRazorpayOrder(purchaseRequest);
		return new PurchaseResponse(orderTrackingNumber, razorpayOrderId);
	}
	
	private String createRazorpayOrder(PurchaseRequest purchaseRequest)throws Exception {
		
		JSONObject orderReq=new JSONObject();
		orderReq.put("amount",purchaseRequest.getOrder().getTotalPrice()*100);
		orderReq.put("currency", "INR");
	//	orderReq.put("reciept", purchaseRequest.getCustomer().getEmail());
		RazorpayClient client=new RazorpayClient(keyId,keySecret);
		com.razorpay.Order razorPayOrder = client.Orders.create(orderReq);
		return razorPayOrder.get("id");

	}

}
