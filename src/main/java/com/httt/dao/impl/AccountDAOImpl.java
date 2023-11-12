package com.httt.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.AccountDAO;
import com.httt.entities.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean signup(Account account) {
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
	public Account checkLogin(String phone, String password) {
		Session session = sessionFactory.openSession();
		try {
			String sqlQuery = "from Account c where c.phone = :phone and c.password = :password";
			Query<Account> query = session.createQuery(sqlQuery);
			
			query.setParameter("phone", phone);
			query.setParameter("password", password);
			
			Account account = query.getResultList().get(0);
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public Account findByPhone(String phone) {
		Session session = sessionFactory.openSession();
		try {
			String sqlQuery = "from Account c where c.phone = :phone";
			Query<Account> query = session.createQuery(sqlQuery);
			
			query.setParameter("phone", phone);
			
			Account account = query.getResultList().get(0);
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
}
