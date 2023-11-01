package com.httt.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.AccountCustomerDAO;
import com.httt.entities.AccountCustomer;

@Repository
public class AccountCustomerDAOImpl implements AccountCustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean signup(AccountCustomer account) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(account);
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
	public AccountCustomer checkLogin(String phone, String password) {
		Session session = sessionFactory.openSession();
		try {
			String sqlQuery = "from AccountCustomer c where c.phone = :phone and c.password = :password";
			Query<AccountCustomer> query = session.createQuery(sqlQuery);
			
			query.setParameter("phone", phone);
			query.setParameter("password", password);
			
			AccountCustomer account = query.getResultList().get(0);
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
}
