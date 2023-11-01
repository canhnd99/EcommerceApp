package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.NewsDAO;
import com.httt.entities.News;


@Repository
public class NewsDAOimpl implements NewsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getNews() {
		Session session = sessionFactory.openSession();
		
		try {
			List<News> news = session.createQuery("from News").list();
			return news;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
