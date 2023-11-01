package com.httt.dao;

import java.util.List;

import com.httt.entities.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	
	public List<Product> getByCategory(Integer categoryId);

	public List<Product> getNewestProducts(Integer numberOfNewestProducts);
	
	public List<Product> getFeatureProducts();
	
	public List<Product> getDiscountProducts();
	
	public List<Product> getBestSaleProducts(Integer numberOfProducts);
	
	public List<Product> search(String key);

	public Product getProductDetail(Integer prodId);
	
	public List<Product> getRelatedProducts(Integer categoryId);
	
	public Product findById(int id);
}
