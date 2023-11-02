package com.httt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.httt.dao.ProductDAO;
import com.httt.entities.Account;
import com.httt.entities.Product;

@Repository
public class ProductDAOimpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
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
	public Product findById(int id) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public List<Product> getByCategory(Integer categoryId) {
		Session session = sessionFactory.openSession();
		try {
			Query<Product> query = null;
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
	public List<Product> getNewestProducts(Integer numberOfNewestProducts) {
		Session session = sessionFactory.openSession();
		try {
			Query<Product> query = session.createQuery("from Product p order by p.creataDate desc");
			List<Product> result = query.getResultList().subList(0, numberOfNewestProducts);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getFeatureProducts() {
		Session session = sessionFactory.openSession();
		try {
			Query<Product> query = session.createQuery("from Product p where p.features = 1 order by p.creataDate desc");
			List<Product> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public Product getProductDetail(Integer prodId) {		
		Session session = sessionFactory.openSession();
		Product product = new Product();
		try {
			product = session.get(Product.class, prodId);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getRelatedProducts(Integer categoryId) {
		Session session = sessionFactory.openSession();
		try {
			Query<Product> query = session.createQuery("from Product p where p.categoryId = :categoryId and rownum <= 5 order by p.creataDate desc");
			query.setParameter("categoryId", categoryId);
			List<Product> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getDiscountProducts() {
		Session session = sessionFactory.openSession();
		try {
			Query<Product> query = session.createQuery("from Product p where p.discount != 0 and p.discount is not null");
			List<Product> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getBestSaleProducts(Integer numberOfProducts) {
		Session session = sessionFactory.openSession();
		try {
			Query<Product> query = session.createQuery("from Product p order by p.quantity desc");
			List<Product> result = query.getResultList().subList(0, numberOfProducts-1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> search(String key) {
		Session session = sessionFactory.openSession();
		try {
			String sqlQuery = "from Product p where lower(p.name) like lower('%" + key + "%')";
			Query<Product> query = session.createQuery(sqlQuery);
			List<Product> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addNew(Product product) {
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
