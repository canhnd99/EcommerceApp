package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.ProductDAO;
import com.httt.entities.Account;
import com.httt.entities.ProductLog;

@Repository
public class ProductDAOimpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProductLog> getProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Product").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public ProductLog findById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(ProductLog.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public List<ProductLog> getByCategory(Integer categoryId) {
		Session session = sessionFactory.openSession();
		try {
			Query<ProductLog> query = null;
			if(categoryId == null) {
				query = session.createQuery("from Product");
			} else {
				query = session.createQuery("from Product p where p.categoryId = :categoryId");
				query.setParameter("categoryId", categoryId);
			}
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ProductLog> getNewestProducts(Integer numberOfNewestProducts) {
		Session session = sessionFactory.openSession();
		try {
			Query<ProductLog> query = session.createQuery("from Product p order by p.createDate desc");
			List<ProductLog> result = query.getResultList().subList(0, numberOfNewestProducts);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ProductLog> getFeatureProducts() {
		Session session = sessionFactory.openSession();
		try {
			Query<ProductLog> query = session.createQuery("from Product p where p.features = 1 order by p.createDate desc");
			List<ProductLog> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public ProductLog getProductDetail(Integer prodId) {		
		Session session = sessionFactory.openSession();
		ProductLog product = new ProductLog();
		try {
			product = session.get(ProductLog.class, prodId);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ProductLog> getRelatedProducts(Integer categoryId) {
		Session session = sessionFactory.openSession();
		try {
			Query<ProductLog> query = session.createQuery("from Product p where p.categoryId = :categoryId and rownum <= 5 order by p.createDate desc");
			query.setParameter("categoryId", categoryId);
			List<ProductLog> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ProductLog> getDiscountProducts() {
		Session session = sessionFactory.openSession();
		try {
			Query<ProductLog> query = session.createQuery("from Product p where p.discount != 0 and p.discount is not null");
			List<ProductLog> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ProductLog> getBestSaleProducts(Integer numberOfProducts) {
		Session session = sessionFactory.openSession();
		try {
			Query<ProductLog> query = session.createQuery("from Product p order by p.quantity desc");
			List<ProductLog> result = query.getResultList().subList(0, numberOfProducts-1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ProductLog> search(String key) {
		Session session = sessionFactory.openSession();
		try {
			String sqlQuery = "from Product p where lower(p.name) like lower('%" + key + "%')";
			Query<ProductLog> query = session.createQuery(sqlQuery);
			List<ProductLog> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addNew(ProductLog product) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(product);
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
