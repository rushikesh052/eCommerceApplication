package com.rushi.dto;

public class PurchaseResponse {
	private String orderTrackingNumber;
	private String razorpayId;
	
	public PurchaseResponse(String orderTrackingNumber, String razorpayId) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
		this.razorpayId = razorpayId;
	}
	
	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}
	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
	public String getRazorpayId() {
		return razorpayId;
	}
	public void setRazorpayId(String razorpayId) {
		this.razorpayId = razorpayId;
	}
	
	
}
