package com.httt.dao.impl;

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
	public boolean addOrderDetail(OrderDetail orderDetail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(orderDetail);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}
}
