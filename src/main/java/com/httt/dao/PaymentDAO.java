package com.httt.dao;

import java.util.List;

import com.httt.entities.Payment;

public interface PaymentDAO {
	public List<Payment> getPaymentMethods();
	
	public boolean addPayment(Payment payment);
}
