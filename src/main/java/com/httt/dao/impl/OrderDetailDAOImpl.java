package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.OrderDetailDAO;
import com.httt.entities.OrderDetail;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OrderDetail> getOrders() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from OrderDetail").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public OrderDetail getOrderById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
