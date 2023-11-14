package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.OrderDAO;
import com.httt.entities.Order;
import com.httt.entities.Product;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder(Order order) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(order);
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

	@Override
	public Order findByOrderCode(String orderCode) {
		Session session = sessionFactory.openSession();
		try {
			Query<Order> query = session.createQuery("from Order o where o.orderCode = :orderCode");
			query.setParameter("orderCode", orderCode);
			Order result = query.getSingleResult();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
