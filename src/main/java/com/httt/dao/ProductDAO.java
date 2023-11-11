package com.httt.dao;

import java.util.List;

import com.httt.entities.ProductLog;

public interface ProductDAO {
	public List<ProductLog> getProducts();
	
	public List<ProductLog> getByCategory(Integer categoryId);

	public List<ProductLog> getNewestProducts(Integer numberOfNewestProducts);
	
	public List<ProductLog> getFeatureProducts();
	
	public List<ProductLog> getDiscountProducts();
	
	public List<ProductLog> getBestSaleProducts(Integer numberOfProducts);
	
	public List<ProductLog> search(String key);

	public ProductLog getProductDetail(Integer prodId);
	
	public List<ProductLog> getRelatedProducts(Integer categoryId);
	
	public ProductLog findById(int id);

	public boolean addNew(ProductLog product);
}
