package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.TransportDAO;
import com.httt.entities.Transport;

@Repository
public class TransportDAOImpl implements TransportDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Transport> getTransports() {
		Session session = sessionFactory.openSession();
		try {
			List<Transport> list = session.createQuery("from Transport").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
