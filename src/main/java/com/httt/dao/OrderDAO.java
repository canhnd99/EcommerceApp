package com.httt.dao;

import com.httt.entities.Order;

public interface OrderDAO {
	boolean addOrder(Order order);
	
	Order findByOrderCode(String orderCode);
}
