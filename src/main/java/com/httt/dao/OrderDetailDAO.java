package com.httt.dao;

import java.util.List;

import com.httt.entities.OrderDetail;

public interface OrderDetailDAO {
//	boolean signup(Account account);
	public List<OrderDetail> getOrders();
	OrderDetail getOrderById(String id);
}
