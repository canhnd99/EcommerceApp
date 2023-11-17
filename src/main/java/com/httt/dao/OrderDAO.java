package com.httt.dao;

import java.util.List;

import com.httt.dto.OrderDto;
import com.httt.entities.Order;

public interface OrderDAO {
	public List<Object[]> getOrders();
	
	boolean addOrder(Order order);
	
	Order findByOrderCode(String orderCode);
}
