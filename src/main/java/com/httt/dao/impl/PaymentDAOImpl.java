package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.PaymentDAO;
import com.httt.entities.Payment;


@Repository
public class PaymentDAOImpl implements PaymentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Payment> getPaymentMethods() {
		Session session = sessionFactory.openSession();
		try {
			List<Payment> list = session.createQuery("from Payment").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
